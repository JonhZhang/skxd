package com.skxd.controller;

import com.skxd.dao.SkxdUserMapper;
import com.skxd.model.SkxdRole;
import com.skxd.model.SkxdUser;
import com.skxd.model.SkxdUserExample;
import com.skxd.service.ISkxdUserService;
import com.skxd.service.impl.SkxdAreaService;
import com.skxd.service.impl.SkxdRoleService;
import com.skxd.util.ExportExcel;
import com.skxd.vo.DataTableVo;
import com.skxd.vo.SkxdUserVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * <p>
 * Created by zzshang on 2015/10/27.
 */
@Controller
@RequestMapping(value = "/admin/user")
public class AdminSkxdUserController {

    @Autowired
    private ISkxdUserService skxdUserService;
    @Autowired
    private SkxdAreaService areaService;
    @Autowired
    private SkxdRoleService roleService;

    @RequestMapping("/toUserPage")
    public String index() {
        return "/user/user_page";
    }

    @RequestMapping("/page")
    @ResponseBody
    public DataTableVo querySkxdUserPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdUserVo> page = skxdUserService.querySkxdUserPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/modifySkxdUser")
    @ResponseBody
    public Integer modifySkxdUser(SkxdUser skxdUser) throws Exception {
        skxdUser.setLeader(null);
        int result = skxdUserService.modifySkxdUser(skxdUser);
        return result;
    }

    @RequestMapping("/selectArea")
    public String selectArea(String userId, Model model, HttpServletRequest request) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        SkxdUser skxdUser = skxdUserService.querySkxdUserById(userId);
        SkxdUserExample skxdUserExample = new SkxdUserExample();
        skxdUserExample.createCriteria().andRoleIdEqualTo("1");
        //查找主管
        List<SkxdUser> skxdUserList = skxdUserService.querySkxdUserList(skxdUserExample);
        List<SkxdRole> skxdRoleList=roleService.findAll();

     


        model.addAttribute("skxdUserList", skxdUserList);
        model.addAttribute("user", skxdUser);
        model.addAttribute("roles", skxdRoleList);
        model.addAttribute("ctx", basePath);
        return "/user/select_area";
    }

    @RequestMapping("/removeSkxdUsersByIds")
    @ResponseBody
    public ReturnResult removeSkxdUsersByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdUserService.removeSkxdUsersByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }





    @Autowired
    private SkxdUserMapper skxdUserMapper;

    @RequestMapping("/selectAssessor")
    public String selectAssessor(String userId,Model model, HttpServletRequest request){
        SkxdUserExample skxdUserExample = new SkxdUserExample();
        skxdUserExample.createCriteria().andRoleIdEqualTo("1");
        //查找全部领导
        List<SkxdUser> allLeaders = skxdUserService.querySkxdUserList(skxdUserExample);

        SkxdUser skxdUser  =  skxdUserMapper.selectByPrimaryKey(userId);
        String selectedLeaderIds = "";


        if(EmptyUtils.isNotEmpty(skxdUser.getLeader())){
            selectedLeaderIds = skxdUser.getLeader();
        }
        model.addAttribute("leaders",allLeaders);
        model.addAttribute("selectedLeaderIds",selectedLeaderIds);
        model.addAttribute("userId",userId);

        return "/user/select_assessor";
    }

    @RequestMapping("/modifyAssessor")
    @ResponseBody
    public ReturnResult modifyAssessor(String[] selectedAssessor, String userId){
        if(EmptyUtils.isEmpty(selectedAssessor)) {
            return ReturnResultUtil.returnFail();
        }
        String assessorStr = "";
        for(String s:selectedAssessor) {
            assessorStr+=s+",";
        }

        SkxdUser user = new SkxdUser();
        user.setId(userId);
        user.setLeader(assessorStr);
        skxdUserMapper.updateByPrimaryKeySelective(user);
        return ReturnResultUtil.returnSuccess();
    }



    @RequestMapping("/exportSkxdUserExcel")
    public void exportSkxdUserExcel(HttpServletResponse response) {

        OutputStream out = null;
        try {
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            response.setHeader("Content-disposition", "attachment;filename=skxdUser" + sdf.format(new Date()) + ".xls");
            out = response.getOutputStream();
            ExportExcel<SkxdUserVo> ex = new ExportExcel<SkxdUserVo>();
            String[] headers = {"Email", "姓名", "状态", "角色","创建时间","公司名称"};
            String[] cloumns = {"userEmail", "userName", "assessor","roleName", "createdTime","company"};

            List<SkxdUserVo> dataset = new ArrayList<SkxdUserVo>();
            Map param = new HashedMap();
            param.put("rows",Integer.MAX_VALUE);
            param.put("page",1);
            Page<SkxdUserVo> page = skxdUserService.querySkxdUserPage(param);
            dataset = page.getRows();
            for(SkxdUserVo user :dataset) {
                if(user.getStatus()==0) {
                    user.setAssessor("审核未通过");
                }else {
                    user.setAssessor("审核通过");
                }
            }
            ex.exportExcel(headers, cloumns, dataset, out);
            System.out.println("excel导出成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @RequestMapping("/setModel")
    @ResponseBody
    public ReturnResult setModel(HttpServletRequest request,final String userId) throws Exception {
        skxdUserService.setModel(userId);
        return ReturnResultUtil.returnSuccess();
    }
}
