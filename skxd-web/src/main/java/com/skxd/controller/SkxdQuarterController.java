package com.skxd.controller;
import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdMessage;
import com.skxd.model.SkxdQuarter;
import com.skxd.service.ISkxdMessageService;
import com.skxd.service.ISkxdQuarterService;
import com.skxd.vo.DataTableVo;
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
import java.io.InputStream;
import java.util.*;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdQuarter")
public class SkxdQuarterController {

    @Autowired
    private ISkxdQuarterService skxdQuarterService;


    @RequestMapping("/toSkxdQuarterPage")
    public String toSkxdQuarterPage() {
        return "skxdQuarter/skxd_quarter_page";
    }

    @RequestMapping("/skxdQuarterPage")
    @ResponseBody
    public DataTableVo skxdQuarterPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdQuarterService.querySkxdQuarterPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdQuarter")
    public String toAddSkxdQuarter(ModelMap model) {
        SkxdQuarter skxdQuarter=new SkxdQuarter("");
        model.addAttribute("skxdQuarter", skxdQuarter);
        return "skxdQuarter/to_edit_skxd_quarter";
    }

    @RequestMapping("/saveOrUpdateSkxdQuarter")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdQuarter(SkxdQuarter skxdQuarter) throws Exception {
        ReturnResult result = null;
        int flag = skxdQuarterService.saveOrUpdateSkxdQuarter(skxdQuarter);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdQuarterByIds")
    @ResponseBody
    public ReturnResult removeSkxdQuarterByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdQuarterService.removeSkxdQuarterByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdQuarter")
    public String toUpdateSkxdQuarter(String id, ModelMap model) throws Exception {
        SkxdQuarter skxdQuarter = skxdQuarterService.querySkxdQuarterById(id);
        model.addAttribute("skxdQuarter", skxdQuarter);
        return "skxdQuarter/to_edit_skxd_quarter";
    }

    @RequestMapping("/toImportSkxdQuarterExcel")
    public String toImportDeviceExcel(){
        return "skxdQuarter/importQuarterExcel";
    }

    /**
     * 导入excel
     */
    @RequestMapping("/importSkxdQuarterExcel")
    @ResponseBody
    public ReturnResult importCustomExcel(HttpServletRequest request) {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream input = null;
        try {
            MultipartFile multipartFile = multipartRequest.getFile("quarterExcel");
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
                SkxdQuarter skxdQuarter = new SkxdQuarter("");
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    System.out.println(cell.getCellType() + "-------------");
                    System.out.println("row_num #" + row.getRowNum() + ">>cell_num #" + cell.getCellNum());
                    String temp ="";
                    if(cell.getCellType()==1){
                        temp=cell.getStringCellValue();
                    }else{
                        temp=cell.getNumericCellValue()+"";
                    }
                    if (EmptyUtils.isNotEmpty(temp)) {
                        if (cell.getCellNum() == 0) {
                            skxdQuarter.setCustomName(temp);
                        }
                        if (cell.getCellNum() == 1) {
                            skxdQuarter.setYear(new Double(Double.parseDouble(temp)).intValue());
                        }
                        if (cell.getCellNum() == 2) {
                            skxdQuarter.setName(temp);
                        }
                        if (cell.getCellNum() == 3) {
                            skxdQuarter.setSpring(Double.parseDouble(temp));
                        }
                        if (cell.getCellNum() == 4) {
                            skxdQuarter.setSummer(Double.parseDouble(temp));
                        }
                        if (cell.getCellNum() == 5) {
                            skxdQuarter.setAutumn(Double.parseDouble(temp));
                        }
                        if (cell.getCellNum() == 6) {
                            skxdQuarter.setWinter(Double.parseDouble(temp));
                        }
                    }
                }
                skxdQuarter.setId(StringUtils.randomUUID());
                skxdQuarter.setCreatedTime(new Date());
                skxdQuarterList.add(skxdQuarter);
            }
            //批量插入
            skxdQuarterService.batchAddSkxdQuarter(skxdQuarterList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
