package com.skxd.controller;
import com.skxd.model.SkxdAdminUser;
import com.skxd.service.ISkxdAdminUserService;
import com.skxd.util.UserSession;
import com.skxd.vo.DataTableVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/admin/skxdAdminUser")
public class SkxdAdminUserController {

    @Autowired
    private ISkxdAdminUserService skxdAdminUserService;


    @RequestMapping("/toSkxdAdminUserPage")
    public String toSkxdAdminUserPage() {
        return "skxdAdminUser/skxd_admin_user_page";
    }

    @RequestMapping("/skxdAdminUserPage")
    @ResponseBody
    public DataTableVo skxdAdminUserPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAdminUserService.querySkxdAdminUserPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdAdminUser")
    public String toAddSkxdAdminUser(ModelMap model) {
        SkxdAdminUser skxdAdminUser=new SkxdAdminUser();
        model.addAttribute("skxdAdminUser",skxdAdminUser);
        return "skxdAdminUser/to_edit_skxd_admin_user";
    }

    @RequestMapping("/saveOrUpdateSkxdAdminUser")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdAdminUser(SkxdAdminUser skxdAdminUser) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminUserService.saveOrUpdateSkxdAdminUser(skxdAdminUser);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdAdminUserByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminUserByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminUserService.removeSkxdAdminUserByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdAdminUser")
    public String toUpdateSkxdAdminUser(String id, ModelMap model) throws Exception {
        SkxdAdminUser skxdAdminUser = skxdAdminUserService.querySkxdAdminUserById(id);
        model.addAttribute("skxdAdminUser", skxdAdminUser);
        return "skxdAdminUser/to_edit_skxd_admin_user";
    }

    @RequestMapping("/toModifyPassword")
    public String toModifyPassword(ModelMap model) {
        SkxdAdminUser skxdAdminUser= UserSession.getLoginSkxdAdminUser();
        model.addAttribute("skxdAdminUser",skxdAdminUser);
        return "skxdAdminUser/to_modify_password";
    }

    @RequestMapping("/modifyPassword")
    @ResponseBody
    public ReturnResult modifyPassword(String oldPassword,String newPassword) throws Exception {
        SkxdAdminUser skxdAdminUser= UserSession.getLoginSkxdAdminUser();
        SkxdAdminUser temp=skxdAdminUserService.validateUser(skxdAdminUser.getName(),oldPassword);
        if(EmptyUtils.isNotEmpty(temp)){
            skxdAdminUser.setPassword(newPassword);
            skxdAdminUser.setUpdatedUser(skxdAdminUser.getName());
            skxdAdminUserService.saveOrUpdateSkxdAdminUser(skxdAdminUser);
        }else{
            return ReturnResultUtil.returnFail("原密码不正确");
        }
        return ReturnResultUtil.returnSuccess();
    }
}
