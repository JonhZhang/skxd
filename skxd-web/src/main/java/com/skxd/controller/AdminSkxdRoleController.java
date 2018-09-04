package com.skxd.controller;
import com.skxd.model.SkxdAdminRole;
import com.skxd.model.SkxdMessage;
import com.skxd.service.ISkxdAdminRoleService;
import com.skxd.service.ISkxdMessageService;
import com.skxd.vo.DataTableVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdAdminRole")
public class AdminSkxdRoleController {

    @Autowired
    private ISkxdAdminRoleService skxdAdminRoleService;


    @RequestMapping("/toSkxdAdminRolePage")
    public String toSkxdAdminRolePage() {
        return "skxdAdminRole/skxd_admin_role_page";
    }

    @RequestMapping("/skxdAdminRolePage")
    @ResponseBody
    public DataTableVo skxdAdminRolePage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAdminRoleService.querySkxdAdminRolePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdAdminRole")
    public String toAddSkxdAdminRole(ModelMap model) {
        SkxdAdminRole skxdAdminRole=new SkxdAdminRole();
        model.addAttribute("skxdAdminRole",skxdAdminRole);
        return "skxdAdminRole/to_edit_skxd_admin_role";
    }

    @RequestMapping("/saveOrUpdateSkxdAdminRole")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdAdminRole(SkxdAdminRole skxdAdminRole) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminRoleService.saveOrUpdateSkxdAdminRole(skxdAdminRole);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdAdminRoleByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminRoleByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminRoleService.removeSkxdAdminRoleByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdAdminRole")
    public String toUpdateSkxdAdminRole(String id, ModelMap model) throws Exception {
        SkxdAdminRole skxdAdminRole = skxdAdminRoleService.querySkxdAdminRoleById(id);
        model.addAttribute("skxdAdminRole", skxdAdminRole);
        return "skxdAdminRole/to_edit_skxd_admin_role";
    }
}
