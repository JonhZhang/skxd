package com.skxd.controller;

import com.skxd.model.SkxdAdminRoleModule;
import com.skxd.model.SkxdMessage;
import com.skxd.service.ISkxdAdminModuleService;
import com.skxd.service.ISkxdAdminRoleModuleService;
import com.skxd.service.ISkxdMessageService;
import com.skxd.vo.DataTableVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdAdminRoleModule")
public class AdminSkxdRoleModuleController {

    @Autowired
    private ISkxdAdminRoleModuleService skxdAdminRoleModuleService;

    @Autowired
    private ISkxdAdminModuleService skxdAdminModuleService;


    @RequestMapping("/toSkxdAdminRoleModulePage")
    public String toSkxdAdminRoleModulePage() {
        return "skxdAdminRoleModule/skxd_admin_role_module_page";
    }

    @RequestMapping("/skxdAdminRoleModulePage")
    @ResponseBody
    public DataTableVo skxdAdminRoleModulePage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAdminRoleModuleService.querySkxdAdminRoleModulePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdAdminRoleModule")
    public String toAddSkxdAdminRoleModule(ModelMap model) {
        SkxdAdminRoleModule skxdAdminRoleModule = new SkxdAdminRoleModule();
        model.addAttribute("skxdAdminRoleModule", skxdAdminRoleModule);
        return "skxdAdminRoleModule/to_edit_skxd_admin_role_module";
    }

    @RequestMapping("/saveOrUpdateSkxdAdminRoleModule")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdAdminRoleModule(SkxdAdminRoleModule skxdAdminRoleModule) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminRoleModuleService.saveOrUpdateSkxdAdminRoleModule(skxdAdminRoleModule);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdAdminRoleModuleByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminRoleModuleByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminRoleModuleService.removeSkxdAdminRoleModuleByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdAdminRoleModule")
    public String toUpdateSkxdAdminRoleModule(String id, ModelMap model) throws Exception {
        SkxdAdminRoleModule skxdAdminRoleModule = skxdAdminRoleModuleService.querySkxdAdminRoleModuleById(id);
        model.addAttribute("skxdAdminRoleModule", skxdAdminRoleModule);
        return "skxdAdminRoleModule/to_edit_skxd_admin_role_module";
    }

    @RequestMapping("/toBindModule")
    public String toBindModule(String roleId,ModelMap model){
        model.addAttribute("roleId",roleId);
        return "skxdAdminRoleModule/to_bind_module";
    }

    @RequestMapping("/bindModule")
    @ResponseBody
    public ReturnResult bindModule(String moduleIds, String roleId) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        String moduleIds_array[] = moduleIds.split(",");
        List<SkxdAdminRoleModule> ymsjRoleModuleList = new ArrayList<SkxdAdminRoleModule>();
        for (int i = 0; i < moduleIds_array.length; i++) {
            SkxdAdminRoleModule ymsjRoleModule = new SkxdAdminRoleModule();
            ymsjRoleModule.setId(StringUtils.randomUUID());
            ymsjRoleModule.setCreatedDate(new Date());
            ymsjRoleModule.setModuleId(moduleIds_array[i]);
            ymsjRoleModule.setRoleId(roleId);
            ymsjRoleModuleList.add(ymsjRoleModule);
        }
        int flag = skxdAdminModuleService.bindModule(ymsjRoleModuleList, roleId);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

}
