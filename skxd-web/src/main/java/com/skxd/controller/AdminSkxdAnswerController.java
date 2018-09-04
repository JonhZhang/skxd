package com.skxd.controller;

import com.skxd.model.*;
import com.skxd.service.IRepairWarningService;
import com.skxd.service.ISkxdAdminInputService;
import com.skxd.service.ISkxdAdminProjectService;
import com.skxd.service.ISkxdAnswerService;
import com.skxd.util.DateUtil;
import com.skxd.util.ExportExcel;
import com.skxd.vo.DataTableVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdAnswer")
public class AdminSkxdAnswerController {

    @Autowired
    private ISkxdAnswerService skxdAnswerService;

    @Autowired
    private ISkxdAdminProjectService skxdAdminProjectService;

    @Autowired
    private ISkxdAdminInputService skxdAdminInputService;

    @Autowired
    private IRepairWarningService repairWarningService;

    @RequestMapping("/toSkxdAnswerPage")
    public String toSkxdAnswerPage(ModelMap modelMap) {
        List<SkxdTemplateProject> skxdTemplateProjectList = skxdAdminProjectService.querySkxdTemplateProjectList();
        modelMap.addAttribute("skxdTemplateProjectList", skxdTemplateProjectList);
        return "skxdAnswer/skxd_answer_page";
    }

    @RequestMapping("/skxdAnswerPage")
    @ResponseBody
    public DataTableVo skxdAnswerPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAnswerService.queryAnswerPageByParams(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/exportAnswerExcel")
    public void exportCustomExcel(String projectId,String startDate,String endDate, HttpServletResponse response) {
        // 测试学生
        OutputStream out = null;
        try {
            Date sDate = DateUtil.strToDate(startDate);
            Date eDate = DateUtil.strToDate(endDate);
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            response.setHeader("Content-disposition", "attachment;filename=工单" + sdf.format(new Date()) + ".xls");
            out = response.getOutputStream();
            ExportExcel<Map<String, String>> ex = new ExportExcel<Map<String, String>>();
            //查询输入有那些字段
            List<SkxdTemplateInput> skxdTemplateInputList = null;
            SkxdTemplateInputExample skxdTemplateInputExample = new SkxdTemplateInputExample();
            skxdTemplateInputExample.createCriteria().andProjectIdEqualTo(projectId).andInputTypeNotEqualTo("view");
            skxdTemplateInputExample.setOrderByClause(" created_date asc ");
            skxdTemplateInputList = skxdAdminInputService.querySkxdTemplateInputList(skxdTemplateInputExample);
            //列转行
            //导出
            String[] headers = new String[14 + skxdTemplateInputList.size()];
            String[] cloumns = new String[14 + skxdTemplateInputList.size()];
            headers[0] = "流水号";
            headers[1] = "工单名称";
            headers[2] = "客户名称";
            headers[3] = "设备号";
            headers[4] = "设备类型";
            headers[5] = "设备状态";
            headers[6] = "客户级别";
            headers[7] = "地址";
            headers[8] = "客户类型";
            headers[9] = "安装人";

            headers[10] = "工程师姓名";
            headers[11] = "销售商";
            headers[12] = "服务商";
            headers[13] = "审核人";

            cloumns[0] = "orderno";
            cloumns[1] = "title";
            cloumns[2] = "customName";
            cloumns[3] = "deviceNo";
            cloumns[4] = "deviceType";
            cloumns[5] = "deviceState";
            cloumns[6] = "customLevel";
            cloumns[7] = "address";
            cloumns[8] = "customType";
            cloumns[9] = "installer";

            cloumns[10] = "userName";
            cloumns[11] = "seller";
            cloumns[12] = "server";
            cloumns[13] = "leaderName";

            for (int i = 0; i < skxdTemplateInputList.size(); i++) {
                String name = skxdTemplateInputList.get(i).getInputName();
                headers[i + 14] = name;
                cloumns[i + 14] = skxdTemplateInputList.get(i).getId();
            }
            List<Map<String, String>> dataset = skxdAnswerService.queryInputValueByProjectId(projectId,startDate,endDate);
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

    @RequestMapping("/toAddSkxdAnswer")
    public String toAddSkxdAnswer(ModelMap model) {
        SkxdAnswer skxdAnswer = new SkxdAnswer();
        model.addAttribute("skxdAnswer", skxdAnswer);
        return "skxdAnswer/to_edit_skxd_answer";
    }

    @RequestMapping("/removeAnswersByIds")
    @ResponseBody
    public ReturnResult removeAnswersByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAnswerService.removeAnswerByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }


    @RequestMapping("/toRepairWarningPage")
    public String toRepairWarningPage(DataTableVo paramDataTableVo) throws Exception {

        return "skxdAnswer/repair_warning_page";
    }

    @RequestMapping("/repairWarningPage")
    @ResponseBody
    public DataTableVo repairWarningPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = repairWarningService.queryPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }
}
