package com.skxd.controller;

import com.alibaba.fastjson.JSONObject;
import com.skxd.model.*;
import com.skxd.service.*;
import com.skxd.util.GenerateHtmlUtil;
import com.skxd.vo.ProjectCache;
import com.skxd.vo.ProjectParamsVo;
import com.skxd.vo.SkxdTemplateStepVo;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.io.PrintUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.List;

/**
 * Created by shang-pc on 2015/11/8.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ISkxdAdminProjectService skxdAdminProjectService;

    @Autowired
    private ISkxdAdminStepService skxdAdminStepService;

    @Autowired
    private ISkxdAdminInputService skxdAdminInputService;

    @Autowired
    private ISkxdFormTemplateService skxdFormTemplateService;

    @Autowired
    private ISkxdAdminDictionaryService skxdAdminDictionaryService;

    @RequestMapping("/generatorProject")
    public void generatorHtmlByProjectId(ProjectParamsVo projectParamsVo, HttpServletResponse response, HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //设置系统输出信息
        Map result = new HashMap();
        PrintUtil printUtil = new PrintUtil(response);

        String html = "";
        try {
            if(EmptyUtils.isEmpty(projectParamsVo) || EmptyUtils.isEmpty(projectParamsVo.getDeviceId()) || EmptyUtils.isEmpty(projectParamsVo.getProjectId()) || EmptyUtils.isEmpty(projectParamsVo.getUserId())){
                printUtil.print(ReturnResultUtil.returnFail("参数为空").toJson());
                return;
            }
            //获取项目
            SkxdTemplateProject skxdTemplateProject = skxdAdminProjectService.findById(projectParamsVo.getProjectId());
            //根据项目获取步骤列表
            List<SkxdTemplateStepVo> skxdTemplateStepVos = skxdAdminStepService.querySkxdTemplateStepListByProjectCache(projectParamsVo.getProjectId());
            //使用步骤装载输入重新传回
            skxdTemplateStepVos = skxdAdminInputService.querySkxdTemplateInputVoListByStepList(skxdTemplateStepVos);
            //获取生成流程模板
            SkxdFormTemplate skxdFormTemplate = skxdFormTemplateService.querySkxdFormTemplateById("1");
            //生成结果集
            result.put("project", skxdTemplateProject);
            result.put("ctx", basePath);
            result.put("stepList", skxdTemplateStepVos);
            result.put("userInfo", projectParamsVo);
            result.put("dictionaryList",skxdAdminDictionaryService.queryAllSkxdAdminDictionary());
            html = GenerateHtmlUtil.generate(skxdFormTemplate.getContent(), result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printUtil.print(html);
        }
    }

    @RequestMapping("/publishingProject")
    public void publishingProject(String projectId,String jsonpCallback,HttpServletResponse response){
        List<SkxdTemplateStep> skxdTemplateStepList = skxdAdminStepService.querySkxdTemplateStepListByProject(projectId);
        ProjectCache.projectSteps.put(projectId,skxdTemplateStepList);
        if(EmptyUtils.isNotEmpty(skxdTemplateStepList)){
            for(int i=0;i<skxdTemplateStepList.size();i++){
                List<SkxdTemplateInput> skxdTemplateInputList = skxdAdminInputService.querySkxdTemplateInputListByStep(skxdTemplateStepList.get(i).getId());
                ProjectCache.stepInputs.put(skxdTemplateStepList.get(i).getId(),skxdTemplateInputList);
            }
        }
        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintUtil printUtil = new PrintUtil(response);
        printUtil.print(jsonpCallback + "(" + JSONObject.toJSONString(ReturnResultUtil.returnSuccess()) + ")");
    }
}
