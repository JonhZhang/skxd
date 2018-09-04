package com.skxd.controller;

import com.skxd.model.*;
import com.skxd.service.ISkxdAdminInputService;
import com.skxd.service.ISkxdAnswerService;
import com.skxd.service.ISkxdCustomService;
import com.skxd.service.ISkxdQuarterService;
import com.skxd.util.ExportExcel;
import com.skxd.vo.DataTableVo;
import com.skxd.vo.SkxdDeviceVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shang-pc on 2016/5/31.
 */
@Controller
@RequestMapping("/admin/statics")
public class AdminStaticsController  {

    @Autowired
    private ISkxdQuarterService skxdQuarterService;

    @RequestMapping("/toStaticsPage")
    public String toStaticsPage(ModelMap modelMap) {
        return "static/statics_page";
    }

    @RequestMapping("/queryStaticsPage")
    @ResponseBody
    public DataTableVo queryStaticsPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdQuarter> page = skxdQuarterService.querySkxdQuarterPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toImportStaticsExcel")
    public String toImportCustomExcel(){
        return "static/importStaticsExcel";
    }

    /**
     * 导入excel`
     */
    @RequestMapping("/importStaticsExcel")
    @ResponseBody
    public ReturnResult importStaticsExcel(HttpServletRequest request) {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream input = null;
        try {
            MultipartFile multipartFile = multipartRequest.getFile("staticsExcel");
            input = multipartFile.getInputStream();
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            HSSFRow row = null;
            if (rows.hasNext()) {
                row = (HSSFRow) rows.next();
            }
            List<SkxdQuarter> skxdQuarterList = new ArrayList<SkxdQuarter>();
            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                SkxdQuarter skxdQuarter = new SkxdQuarter();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    System.out.println("row_num #" + row.getRowNum() + ">>cell_num #" + cell.getCellNum());
                    String temp = cell.getStringCellValue();
                    if (EmptyUtils.isNotEmpty(temp)) {
                        if (cell.getCellNum() == 0) {
                            skxdQuarter.setName(temp);
                        }
                        if (cell.getCellNum() == 1) {
                            skxdQuarter.setStaticType(temp);
                        }
                        if (cell.getCellNum() == 2) {
                            skxdQuarter.setCustomName(temp);
                        }
                        if (cell.getCellNum() == 3) {
                            skxdQuarter.setYear(Integer.parseInt(temp));
                        }
                        if (cell.getCellNum() == 4) {
                            skxdQuarter.setSpring(Double.parseDouble(temp));
                        }
                        if (cell.getCellNum() == 5) {
                            skxdQuarter.setSummer(Double.parseDouble(temp));
                        }
                        if (cell.getCellNum() == 6) {
                            skxdQuarter.setAutumn(Double.parseDouble(temp));
                        }
                        if (cell.getCellNum() == 6) {
                            skxdQuarter.setWinter(Double.parseDouble(temp));
                        }
                    }
                }
                skxdQuarter.setId(StringUtils.randomUUID());
                skxdQuarterList.add(skxdQuarter);
            }
            //批量插入
            skxdQuarterService.batchAddSkxdQuarter(skxdQuarterList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 导出统计信息Excel
     */
    @RequestMapping("/exportStaticsExcel")
    public void exportStaticsExcel(HttpServletResponse response) {
        // 测试学生
        OutputStream out = null;
        try {
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            response.setHeader("Content-disposition", "attachment;filename=device" + sdf.format(new Date()) + ".xls");
            out = response.getOutputStream();
            ExportExcel<SkxdQuarter> ex = new ExportExcel<SkxdQuarter>();
            String[] headers = {"选项名称", "选项类型", "客户名称", "统计年份","第一季度","第二季度","第三季度","第四季度"};
            String[] cloumns = {"name", "staticType", "customName", "year","spring","summer","autumn","winter"};
            List<SkxdQuarter> dataset = new ArrayList<SkxdQuarter>();
            SkxdQuarterExample skxdQuarterExample=new SkxdQuarterExample();
            dataset = skxdQuarterService.querySkxdQuarterList(skxdQuarterExample);
            ex.exportExcel(headers, cloumns, dataset, out);
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


}
