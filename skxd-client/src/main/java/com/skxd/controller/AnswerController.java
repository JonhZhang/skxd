package com.skxd.controller;

import com.skxd.model.*;
import com.skxd.service.*;
import com.skxd.util.GenerateHtmlUtil;
import com.skxd.util.PushUtil;
import com.skxd.vo.*;
import com.zxs.common.Constant;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.io.PrintUtil;
import com.zxs.utils.io.PropCache;
import com.zxs.utils.lang.DateUtils;

import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

/**
 * Created by shang-pc on 2015/11/15.
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private ISkxdAnswerService skxdAnswerService;

    @Autowired
    private ISkxdFormTemplateService skxdFormTemplateService;

    @Autowired
    private ISkxdAdminProjectService skxdAdminProjectService;

    @Autowired
    private ISkxdUserService skxdUserService;

    @Autowired
    private ISkxdCustomService skxdCustomService;

    @Autowired
    private ISkxdAdminStepService skxdAdminStepService;

    @Autowired
    private ISkxdAdminInputService skxdAdminInputService;

    @Autowired
    private ISkxdDeviceService skxdDeviceService;
    
	@Autowired
	private ISkxdMessageService messageService;

    @Autowired
    private ISkxdAdminDictionaryValueService skxdAdminDictionaryValueService;

    @Autowired
    private IRepairWarningService repairWarningService;

    @RequestMapping("/execute")
    @ResponseBody
    public ReturnResult answer(ProjectParamsVo projectParamsVo, String answers) throws Exception {

        //保存
        String anId =  skxdAnswerService.addSkxdAnswerValue(projectParamsVo, answers);
        List<SkxdUser> leaders = skxdUserService.findLeaders(projectParamsVo.getUserId());
        SkxdUser user =  skxdUserService.querySkxdUserById(projectParamsVo.getUserId());
        List<String> emails = new ArrayList<>();
        List<String> leaderIds = new ArrayList<>();
        if(EmptyUtils.isNotEmpty(leaders)) {
        	String content = projectParamsVo.getTitle();
        	if(projectParamsVo.getTitle().length() > 20) {
        		content =  content.substring(0, 20);
        	}
            for(SkxdUser u:leaders) {
                emails.add(u.getUserEmail());
                leaderIds.add(u.getId());
            }
            String title =  user.getUserName()+"于"+DateUtils.format(new Date())+"提交工单";
            PushUtil.sendPush(title,content, emails);


        }
        String targetProjectId = PropCache.getValue("prop/regResp", "project_id");
        if(projectParamsVo.getProjectId().equals(targetProjectId)) {
            SkxdDevice device  =  skxdDeviceService.queryDeviceById(projectParamsVo.getDeviceId());
            SkxdUser skxdUser =  skxdUserService.querySkxdUserById(projectParamsVo.getUserId());
            List<RepairWarning> repairWarnings =  repairWarningService.findListByDeviceId(projectParamsVo.getDeviceId());
            //添加维修记录
            addRepairWarning(projectParamsVo, user, device);
            //有30天内的维修记录
            if(repairWarnings.size()>0) {
                String title =  "重复维修报警";
                String content = "编号为："+device.getDeviceNo()+"的设备发生重复维修。";
                System.out.println(content);
                for(String rid:leaderIds) {
                    SkxdMessage users = new SkxdMessage();
                    users.setContent(content);
                    users.setTitle(title);
                    users.setSenderId(user.getId());
                    users.setSenderName(user.getUserName());
                    users.setRecipient(rid);
                    users.setMessageType("1");

                    users.setCreatedUserId(anId);
                    this.messageService.saveOrUpdateSkxdMessage(users);
                }


                PushUtil.sendPush(title,content, emails);
            }
        }


        if (anId  == null) {
            return ReturnResultUtil.returnFail();
        } else {
            return ReturnResultUtil.returnSuccess();
        }

    }

    @RequestMapping("/queryAnswerById")
    public void queryAnswersById(String answerId, HttpServletResponse response, HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //设置系统输出信息
        Map result = new HashMap();
        PrintUtil printUtil = new PrintUtil(response);
        String html = "";
        try {
            //找到试卷编号
            SkxdAnswer skxdAnswer = skxdAnswerService.querySkxdAnswerById(answerId);
            SkxdDevice skxdDevice=skxdDeviceService.queryDeviceById(skxdAnswer.getDeviceId());
            SkxdUser skxdUser = skxdUserService.querySkxdUserById(skxdAnswer.getUserId());
            SkxdTemplateProject skxdTemplateProject = skxdAdminProjectService.findById(skxdAnswer.getProjectId());
            //根据项目获取步骤列表
            List<SkxdTemplateStepVo> skxdTemplateStepVos = skxdAdminStepService.querySkxdTemplateStepListByProjectCache(skxdAnswer.getProjectId());
            //使用步骤装载输入重新传回querySkxdTemplateInputVoListByStepList
            skxdTemplateStepVos = skxdAdminInputService.querySkxdTemplateInputAnswerListByStepList(skxdTemplateStepVos, answerId);
            //获取生成流程模板
            SkxdFormTemplate skxdFormTemplate = skxdFormTemplateService.querySkxdFormTemplateById("2");
//          //// TODO: 2015/11/29
            SkxdCustom skxdCustom = skxdCustomService.queryCustomById(skxdDevice.getCustomId());
            //生成结果集
            AnswerVo answerVo = new AnswerVo();
            BeanUtils.copyProperties(skxdAnswer, answerVo);
            answerVo.setUserName(skxdUser.getUserName());
            result.put("project", skxdTemplateProject);
            result.put("ctx", basePath);
            result.put("stepList", skxdTemplateStepVos);
            result.put("skxdCustom", skxdCustom);
            result.put("answer", answerVo);
            result.put("skxdUser", skxdUser);
            result.put("skxdDevice", skxdDevice);
            html = GenerateHtmlUtil.generate(skxdFormTemplate.getContent(), result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printUtil.print(html);
        }
    }

    @RequestMapping("/queryDicList")
    @ResponseBody
    public ReturnResult queryDicList(String dId){
        ReturnResult result=new ReturnResult();
        result.setStatus(Constant.ReturnResult.STATUS.SUCCESS);
        result.setData(skxdAdminDictionaryValueService.querySkxdAdminDictionaryValueByDictionary(dId));
        return result;
    }

    private void addRepairWarning(ProjectParamsVo projectParamsVo, SkxdUser user, SkxdDevice device) throws Exception {
        RepairWarning repairWarning = new RepairWarning();
        repairWarning.setCreatedDate(new Date());
        repairWarning.setDeviceId(projectParamsVo.getDeviceId());
        repairWarning.setDeviceType(device.getDeviceType());
        repairWarning.setDeviceNo(device.getDeviceNo());
        repairWarning.setProjectId(projectParamsVo.getProjectId());
        repairWarning.setUserId(user.getId());
        repairWarning.setUserName(user.getUserName());
        repairWarning.setId(StringUtils.randomUUID());
        repairWarningService.save(repairWarning);
        System.out.println("维修记录添加成功");
    }

}
