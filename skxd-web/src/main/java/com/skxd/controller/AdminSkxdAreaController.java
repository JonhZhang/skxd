package com.skxd.controller;
import com.skxd.model.SkxdArea;
import com.skxd.service.ISkxdAreaService;
import com.skxd.vo.DataTableVo;
import com.zxs.common.Page;
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
@RequestMapping("/admin/skxdArea")
public class AdminSkxdAreaController {

    @Autowired
    private ISkxdAreaService skxdAreaService;


    @RequestMapping("/toSkxdAreaPage")
    public String toSkxdAreaPage() {
        return "skxdArea/skxd_area_page";
    }

    @RequestMapping("/skxdAreaPage")
    @ResponseBody
    public DataTableVo skxdAreaPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAreaService.querySkxdAreaPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdArea")
    public String toAddSkxdArea(ModelMap model) {
        SkxdArea skxdArea=new SkxdArea();
        model.addAttribute("skxdArea",skxdArea);
        return "skxdArea/to_edit_skxd_area";
    }
}
