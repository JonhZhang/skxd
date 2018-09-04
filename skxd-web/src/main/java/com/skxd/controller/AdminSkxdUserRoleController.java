package com.skxd.controller;
import com.skxd.model.*;
import com.skxd.service.ISkxdAdminRoleService;
import com.skxd.service.ISkxdAdminUserRoleService;
import com.skxd.service.ISkxdAdminUserService;
import com.skxd.service.ISkxdMessageService;
import com.skxd.vo.DataTableVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdAdminUserRole")
public class AdminSkxdUserRoleController {

    @Autowired
    private ISkxdAdminUserRoleService skxdAdminUserRoleService;

    @Autowired
    private ISkxdAdminRoleService skxdAdminRoleService;

    @Autowired
    private ISkxdAdminUserService skxdAdminUserService;


    @RequestMapping("/toSkxdAdminUserRolePage")
    public String toSkxdAdminUserRolePage() {
        return "skxdAdminUserRole/skxd_admin_user_role_page";
    }

    @RequestMapping("/skxdAdminUserRolePage")
    @ResponseBody
    public DataTableVo skxdAdminUserRolePage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAdminUserRoleService.querySkxdAdminUserRolePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdAdminUserRole")
    public String toAddSkxdAdminUserRole(ModelMap model) {
        SkxdAdminUserRole skxdAdminUserRole=new SkxdAdminUserRole();
        model.addAttribute("skxdAdminUserRole",skxdAdminUserRole);
        return "skxdAdminUserRole/to_edit_skxd_admin_user_role";
    }

    @RequestMapping("/saveOrUpdateSkxdAdminUserRole")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdAdminUserRole(SkxdAdminUserRole skxdAdminUserRole) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminUserRoleService.saveOrUpdateSkxdAdminUserRole(skxdAdminUserRole);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdAdminUserRoleByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminUserRoleByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminUserRoleService.removeSkxdAdminUserRoleByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdAdminUserRole")
    public String toUpdateSkxdAdminUserRole(String id, ModelMap model) throws Exception {
        SkxdAdminUserRole skxdAdminUserRole = skxdAdminUserRoleService.querySkxdAdminUserRoleById(id);
        model.addAttribute("skxdAdminUserRole", skxdAdminUserRole);
        return "skxdAdminUserRole/to_edit_skxd_admin_user_role";
    }

    @RequestMapping("/toBindRole")
    public String toBindRole(String userId,ModelMap modelMap) throws Exception {
        SkxdAdminRoleExample skxdAdminRoleExample=new SkxdAdminRoleExample();
        skxdAdminRoleExample.createCriteria();
        List<SkxdAdminRole> skxdAdminRoleList=skxdAdminRoleService.querySkxdAdminRoleList(skxdAdminRoleExample);
        SkxdAdminUser skxdAdminUser=skxdAdminUserService.querySkxdAdminUserById(userId);
        SkxdAdminUserRoleExample skxdAdminUserRoleExample=new SkxdAdminUserRoleExample();
        skxdAdminUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<SkxdAdminUserRole> skxdAdminUserRoleList=skxdAdminUserRoleService.querySkxdAdminUserRoleList(skxdAdminUserRoleExample);
        SkxdAdminUserRole skxdAdminUserRole=new SkxdAdminUserRole();
        if(EmptyUtils.isNotEmpty(skxdAdminUserRoleList)){
            skxdAdminUserRole=skxdAdminUserRoleList.get(0);
        }else{
            skxdAdminUserRole.setUserId(userId);
        }
        modelMap.addAttribute("skxdAdminRoleList", skxdAdminRoleList);
        modelMap.addAttribute("skxdAdminUserRole",skxdAdminUserRole);
        modelMap.addAttribute("skxdAdminUser", skxdAdminUser);
        return "skxdAdminUserRole/to_edit_skxd_admin_user_role";
    }


}
