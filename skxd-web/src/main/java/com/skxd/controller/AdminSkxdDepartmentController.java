package com.skxd.controller;
import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdDepartment;
import com.skxd.service.impl.SkxdDepartmentService;
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
@RequestMapping("/admin/department")
public class AdminSkxdDepartmentController {

    @Autowired
    private SkxdDepartmentService skxdDepartmentService;

    @RequestMapping("/toDepartmentPage")
    public String toDepartmentPage(){
        return "custom/department_page";
    }

    @RequestMapping("/departmentPage")
    @ResponseBody
    public DataTableVo departmentPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo =null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdDepartment> page=skxdDepartmentService.queryDepartmentPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/removeDepartmentByIds")
    @ResponseBody
    public ReturnResult removeSkxdDepartmentByIds(String ids) throws Exception {
        ReturnResult result=ReturnResultUtil.returnSuccess();
        int flag=skxdDepartmentService.removeDepartmentByIds(ids);
        if(flag==0){
            result=ReturnResultUtil.returnFail();
        }else{
            result=ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateDepartment")
    public String toUpdateDepartment(String id,ModelMap model) throws Exception {
        SkxdDepartment skxdDepartment=skxdDepartmentService.queryDepartmentById(id);
        model.addAttribute("department",skxdDepartment);
        return "custom/to_update_department";
    }

    @RequestMapping("/toAddDepartment")
    public String toAddDepartment(ModelMap model) throws Exception {
        model.addAttribute("department",new SkxdDepartment());
        return "custom/to_update_department";
    }

    @RequestMapping("/saveOrUpdateDepartment")
    @ResponseBody
    public ReturnResult saveOrUpdateDepartment(SkxdDepartment skxdDepartment) throws Exception {
        ReturnResult result=null;
        int flag=skxdDepartmentService.saveOrUpdateDepartment(skxdDepartment);
        if(flag==0){
            result= ReturnResultUtil.returnFail();
        }else{
            result=ReturnResultUtil.returnSuccess();
        }
        return result;
    }
}
