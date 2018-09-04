package com.skxd.controller;
import com.skxd.model.*;
import com.skxd.service.impl.*;
import com.skxd.util.DateEditor;
import com.skxd.util.DateUtil;
import com.skxd.util.ExportExcel;
import com.skxd.vo.DataTableVo;
import com.skxd.vo.SkxdDeviceVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/custom")
public class AdminSkxdCustomController {

    @Autowired
    private SkxdCustomService skxdCustomService;

    @Autowired
    private SkxdAreaService skxdAreaService;

    @Autowired
    private SkxdDeviceService skxdDeviceService;

    @Autowired
    private SkxdDepartmentService skxdDepartmentService;

    @RequestMapping("/toCustomPage")
    public String toCustomPage(ModelMap model) {
        List<SkxdArea> province = skxdAreaService.findCityByParent("0");
        List<SkxdArea> cityList = skxdAreaService.findCityByParent(province.get(0).getAreaNo());
        model.addAttribute("province", province);
        model.addAttribute("cityList", cityList);
        model.addAttribute("areaNo1", province.get(0).getAreaNo());
        model.addAttribute("areaNo", province);
        return "custom/custom_page";
    }

    @RequestMapping("/customPage")
    @ResponseBody
    public DataTableVo customPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdCustom> page = skxdCustomService.queryCustomPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddCustom")
    public String toAddCustom(ModelMap model) {
        List<SkxdArea> province = skxdAreaService.findCityByParent("0");
        model.addAttribute("custom", new SkxdCustom());
        model.addAttribute("province", province);
        return "custom/to_update_custom";
    }

    @RequestMapping("/saveOrUpdateCustom")
    @ResponseBody
    public ReturnResult saveOrUpdateCustom(SkxdCustom skxdCustom) throws Exception {
        ReturnResult result = null;
        int flag = skxdCustomService.saveOrUpdateCustom(skxdCustom);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeCustomByIds")
    @ResponseBody
    public ReturnResult removeSkxdCustomByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdCustomService.removeCustomByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateCustom")
    public String toUpdateCustom(String id, ModelMap model) throws Exception {
        SkxdCustom skxdCustom = skxdCustomService.queryCustomById(id);
        List<SkxdArea> province = skxdAreaService.findCityByParent("0");
        SkxdArea skxdArea = skxdAreaService.querySkxdAreaByAreaNo(skxdCustom.getAreaNo());
        List<SkxdArea> cityList = skxdAreaService.findCityByParent(skxdArea.getParent());
        model.addAttribute("custom", skxdCustom);
        model.addAttribute("province", province);
        model.addAttribute("cityList", cityList);
        model.addAttribute("area", skxdArea);
        return "custom/to_update_custom";
    }

    @RequestMapping("/toDevicePage")
    public String toDevicePage(String customId, ModelMap model) {
        model.addAttribute("customId", customId);
        return "custom/device_page";
    }

    @RequestMapping("/devicePage")
    @ResponseBody
    public DataTableVo devicePage(DataTableVo paramDataTableVo, String customId) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        if (EmptyUtils.isNotEmpty(customId)) {
            params.put("customId", customId);
        }
        Page<SkxdDeviceVo> page = skxdDeviceService.queryDevicePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/removeDeviceByIds")
    @ResponseBody
    public ReturnResult removeSkxdDeviceByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdDeviceService.removeDeviceByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateDevice")
    public String toUpdateDevice(String id, ModelMap model) throws Exception {
        List<SkxdDepartment> departmentList = skxdDepartmentService.queryDepartmentAll();
        SkxdDevice skxdDevice = skxdDeviceService.queryDeviceById(id);
        SkxdCustom skxdCustom = skxdCustomService.queryCustomById(skxdDevice.getCustomId());
        List<SkxdCustom> skxdCustomList = skxdCustomService.queryCustomByAreaNo(skxdCustom.getAreaNo());
        SkxdArea city = skxdAreaService.querySkxdAreaByAreaNo(skxdCustom.getAreaNo());
        SkxdArea province = skxdAreaService.querySkxdAreaByAreaNo(city.getParent());
        model.addAttribute("province", province);
        model.addAttribute("city", city);
        model.addAttribute("customList", skxdCustomList);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("device", skxdDevice);
        model.addAttribute("installTime", DateUtil.dateToStr(skxdDevice.getInstallTime(),"yyyy-MM-dd"));
        return "custom/to_update_device";
    }

    @RequestMapping("/toAddDevice")
    public String toAddDevice(ModelMap model) throws Exception {
        List<SkxdDepartment> departmentList = skxdDepartmentService.queryDepartmentAll();
        List<SkxdArea> provinceList = skxdAreaService.findCityByParent("0");
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("device", new SkxdDevice());
        return "custom/to_update_device";
    }

    @RequestMapping("/queryCustomListByAreaNo")
    @ResponseBody
    public List<SkxdCustom> queryCustomListByAreaNo(String areaNo) throws Exception {
        List<SkxdCustom> skxdCustomList = skxdCustomService.queryCustomByAreaNo(areaNo);
        return skxdCustomList;
    }

    @RequestMapping("/saveOrUpdateDevice")
    @ResponseBody
    public ReturnResult saveOrUpdateDevice(SkxdDevice skxdDevice) throws Exception {
        ReturnResult result = null;
        int flag = skxdDeviceService.saveOrUpdateDevice(skxdDevice);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toAddTemplate")
    public String toAddTemplate(ModelMap model) {
        List<SkxdArea> province = skxdAreaService.findCityByParent("0");
        model.addAttribute("custom", new SkxdCustom());
        model.addAttribute("province", province);
        return "custom/to_add_template";
    }
    /**
     * 导出客户Excel
     */
    @RequestMapping("/exportCustomExcel")
    public void exportCustomExcel(HttpServletResponse response) {
        // 测试学生
        OutputStream out = null;
        try {
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            response.setHeader("Content-disposition", "attachment;filename=custom" + sdf.format(new Date()) + ".xls");
            out = response.getOutputStream();
            ExportExcel<SkxdCustom> ex = new ExportExcel<SkxdCustom>();
            String[] headers = {"客户姓名", "客户地址","区域编号","客户类型","客户级别","空间质评","创建时间","创建人"};
            String[] cloumns = {"customName", "address","areaNo","customType","customLevel","roomTest", "createdDate","createdUser"};
            List<SkxdCustom> dataset = new ArrayList<SkxdCustom>();
            SkxdCustomExample skxdCustomExample = new SkxdCustomExample();
            skxdCustomExample.createCriteria();
            dataset = skxdCustomService.querySkxdCustomList(skxdCustomExample);
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

    @RequestMapping("/toImportCustomExcel")
    public String toImportCustomExcel(){
        return "custom/importCustomExcel";
    }

    /**
     * 导入excel`
     */
    @RequestMapping("/importCustomExcel")
    @ResponseBody
    public ReturnResult importCustomExcel(HttpServletRequest request) {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream input = null;
        try {
            MultipartFile multipartFile = multipartRequest.getFile("customExcel");
            input = multipartFile.getInputStream();
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            HSSFRow row = null;
            if (rows.hasNext()) {
                row = (HSSFRow) rows.next();
            }
            List<SkxdCustom> skxdCustomList = new ArrayList<SkxdCustom>();
            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                SkxdCustom skxdCustom = new SkxdCustom();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    System.out.println("row_num #" + row.getRowNum() + ">>cell_num #" + cell.getCellNum());
                    String temp = cell.getStringCellValue();
                    if (EmptyUtils.isNotEmpty(temp)) {
                        if (cell.getCellNum() == 0) {
                            skxdCustom.setCustomName(temp);
                        }
                        if (cell.getCellNum() == 1) {
                            skxdCustom.setAddress(temp);
                        }
                        //区域
                        if (cell.getCellNum() == 2) {
                            String areaNo = skxdAreaService.getAreaNoByName(temp);
                            skxdCustom.setAreaNo(areaNo);
                        }
                        if (cell.getCellNum() == 3) {
                            skxdCustom.setCustomType(temp);
                        }
                        if (cell.getCellNum() == 4) {
                            skxdCustom.setCustomLevel(temp);
                        }if (cell.getCellNum() == 5) {
                            skxdCustom.setRoomTest(temp);
                        }
                    }
                }
                skxdCustom.setId(StringUtils.randomUUID());
                skxdCustom.setCreatedDate(new Date());
                //判断客户是否为空
                if(skxdCustom!=null && EmptyUtils.isNotEmpty(skxdCustom.getCustomName()) && EmptyUtils.isNotEmpty(skxdCustom.getAreaNo())){
                    skxdCustomList.add(skxdCustom);
                }
            }
            //批量插入
            skxdCustomService.batchSaveCustomList(skxdCustomList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 导出设备Excel
     */
    @RequestMapping("/exportDeviceExcel")
    public void exportDeviceExcel(HttpServletResponse response) {
        // 测试学生
        OutputStream out = null;
        try {
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            response.setHeader("Content-disposition", "attachment;filename=device" + sdf.format(new Date()) + ".xls");
            out = response.getOutputStream();
            ExportExcel<SkxdDeviceVo> ex = new ExportExcel<SkxdDeviceVo>();
            String[] headers = {"省","市","客户姓名", "部门名称", "仪器型号", "仪器编号","固定电话","负责人姓名","负责人联系方式","操作员姓名","操作员电话","销售商","服务机构","安装人","安装时间","仪器状态","项目开展情况","对手信息","创建人","创建时间","客户类型","客户级别","室间质评"};
            String[] cloumns = {"province","city","customName", "departMentName", "deviceType","deviceNo","fixedPhone","leaderName","leaderPhone","operatorName","operatorPhone","seller","server",
                    "installer","installTime","deviceState","projectRemark","competitor","createdUser","createdDate","customType","customLevel","roomTest"};
            List<SkxdDeviceVo> dataset = skxdDeviceService.queryDeviceList();
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

    @RequestMapping("/toImportDeviceExcel")
    public String toImportDeviceExcel(){
        return "custom/importDeviceExcel";
    }

    /**
     * 导入excel
     */
    @RequestMapping("/importDeviceExcel")
    @ResponseBody
    public ReturnResult importDeviceExcel(HttpServletRequest request) {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream input = null;
        try {
            MultipartFile multipartFile = multipartRequest.getFile("deviceExcel");
            input = multipartFile.getInputStream();
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            HSSFRow row = null;
            if (rows.hasNext()) {
                row = (HSSFRow) rows.next();
            }
            List<SkxdDevice> skxdDeviceList = new ArrayList<SkxdDevice>();
            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                SkxdDevice skxdDevice = new SkxdDevice();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    System.out.println("row_num #" + row.getRowNum() + ">>cell_num #" + cell.getCellNum());
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String temp = cell.getStringCellValue();
                    if (EmptyUtils.isNotEmpty(temp)) {
                        //客户
                        if (cell.getCellNum() == 0) {
                            String customId=skxdCustomService.getCustomIdByCustomName(temp,row.getRowNum());
                            skxdDevice.setCustomId(customId);
                        }
                        //部门
                        if (cell.getCellNum() == 1) {
                          String departmentId=skxdDepartmentService.queryDepartmentIdByName(temp, row.getRowNum());
                            skxdDevice.setDepartmentId(departmentId);
                        }
                        //设备
                        if (cell.getCellNum() == 2) {
                            skxdDevice.setDeviceType(temp);
                        }
                        if (cell.getCellNum() == 3) {
                            skxdDevice.setDeviceNo(temp);
                        }
                        if (cell.getCellNum() == 4) {
                            skxdDevice.setLeaderName(temp);
                        }
                        if (cell.getCellNum() == 5) {
                            skxdDevice.setFixedPhone(temp);
                        }
                        if (cell.getCellNum() == 6) {
                            skxdDevice.setLeaderPhone(temp);
                        }
                        if (cell.getCellNum() == 7) {
                            skxdDevice.setOperatorName(temp);
                        }
                        if (cell.getCellNum() == 8) {
                            skxdDevice.setOperatorPhone(temp);
                        }
                        if (cell.getCellNum() == 9) {
                            skxdDevice.setSeller(temp);
                        }
                        if (cell.getCellNum() == 10) {
                            skxdDevice.setServer(temp);
                        }
                        if (cell.getCellNum() == 11) {
                            skxdDevice.setInstaller(temp);
                        }
                        if (cell.getCellNum() == 12) {
                            skxdDevice.setInstallTime(temp==null? null:DateUtil.strToDate(temp,"yyyy/MM/dd"));
                        }
                        if (cell.getCellNum() == 13) {
                            skxdDevice.setDeviceState(temp);
                        }
                        if (cell.getCellNum() == 14) {
                            skxdDevice.setProjectRemark(temp);
                        }
                        if (cell.getCellNum() == 15) {
                            skxdDevice.setCompetitor(temp);
                        }
                    }
                }
                skxdDevice.setId(StringUtils.randomUUID());
                skxdDevice.setCreatedDate(new Date());
                skxdDeviceList.add(skxdDevice);
            }
            //批量插入
            skxdDeviceService.batchSaveDeviceList(skxdDeviceList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/queryStaticsPage")
    @ResponseBody
    public DataTableVo queryStaticsPage(DataTableVo paramDataTableVo,String customId) throws Exception {
        DataTableVo dataTableVo =new DataTableVo();
        Page<SkxdQuarter> page = new Page<SkxdQuarter>();
        String yearStr=paramDataTableVo.getsSearch();
        Integer year=0;
        if(EmptyUtils.isNotEmpty(yearStr)){
            year=Integer.parseInt(yearStr);
        }
        List<SkxdQuarter> quarterVoList = this.skxdCustomService.queryStatics(customId,year);
        if(EmptyUtils.isNotEmpty(page)){
            dataTableVo.setAaData(quarterVoList);
            dataTableVo.setiTotalDisplayRecords(new Long(quarterVoList.size()));
            dataTableVo.setiTotalRecords(new Long(quarterVoList.size()));
            dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        }
        return dataTableVo;
    }

    @RequestMapping("/toStaticsPage")
    public String toCustomPage(String customId,ModelMap modelMap) {
        modelMap.addAttribute("customId",customId);
        return "custom/custom_statics_page";
    }
    /**
     * 导出统计信息Excel
     */
    @RequestMapping("/exportStaticsExcel")
    public void exportStaticsExcel(HttpServletResponse response,String customId) {
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
            dataset =this.skxdCustomService.queryStatics(customId,null);
            for(SkxdQuarter skxdQuarter:dataset){
                if(skxdQuarter.getStaticType().equals("1")){
                    skxdQuarter.setStaticType("凝血标本量及质控开展情况");
                }else if(skxdQuarter.getStaticType().equals("2")){
                    skxdQuarter.setStaticType("流变标本量及质控开展情况");
                }else{
                    skxdQuarter.setStaticType("未知统计类型");
                }
            }
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

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
