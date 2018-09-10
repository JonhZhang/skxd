package com.skxd.controller;

import com.skxd.model.SkxdUser;
import com.skxd.model.SkxdUserPower;
import com.skxd.service.ISkxdAreaService;
import com.skxd.service.ISkxdCustomService;
import com.skxd.service.ISkxdDeviceService;
import com.skxd.service.ISkxdUserPowerService;
import com.skxd.service.impl.SkxdUserService;
import com.skxd.util.HttpUtil;
import com.skxd.vo.DataTableVo;
import com.skxd.vo.SkxdUserVo;
import com.zxs.common.Constant;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdUserPower")
public class AdminSkxdUserPowerController {

    @Autowired
    private ISkxdUserPowerService skxdUserPowerService;

    @Autowired
    private ISkxdCustomService skxdCustomService;

    @Autowired
    private ISkxdDeviceService skxdDeviceService;
    @Autowired
    private SkxdUserService skxdUserService;

    @RequestMapping("/toSkxdUserPowerPage")
    public String toSkxdUserPowerPage() {
        return "skxdUserPower/skxd_user_power_page";
    }

    @RequestMapping("/skxdUserPowerPage")
    @ResponseBody
    public DataTableVo skxdUserPowerPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map<String, Object> params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdUserPowerService.querySkxdUserPowerPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdUserPower")
    public String toAddSkxdUserPower(ModelMap model) {
        SkxdUserPower skxdUserPower = new SkxdUserPower();
        model.addAttribute("skxdUserPower", skxdUserPower);
        return "skxdUserPower/to_edit_skxd_user_power";
    }

    @RequestMapping("/saveOrUpdateSkxdUserPower")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdUserPower(SkxdUserPower skxdUserPower) throws Exception {
        ReturnResult result = null;
        int flag = skxdUserPowerService.saveOrUpdateSkxdUserPower(skxdUserPower);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdUserPowerByIds")
    @ResponseBody
    public ReturnResult removeSkxdUserPowerByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdUserPowerService.removeSkxdUserPowerByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdUserPower")
    public String toUpdateSkxdUserPower(String id, ModelMap model) throws Exception {
        SkxdUserPower skxdUserPower = skxdUserPowerService.querySkxdUserPowerById(id);
        model.addAttribute("skxdUserPower", skxdUserPower);
        return "skxdUserPower/to_edit_skxd_user_power";
    }

    @RequestMapping("/toSelectArea")
    public String toSelectArea(String id, int level, ModelMap model) throws Exception {
        //查询当前用户的id
        model.addAttribute("userId", id);
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(id);
        if (EmptyUtils.isEmpty(skxdUserPower)) {
            model.addAttribute("areaNos", "");
        } else {
            model.addAttribute("areaNos", level == 1 ? skxdUserPower.getProvinceNo() : skxdUserPower.getCityNo());
        }


        Map params = new HashMap();
        params.put("page","1");
        params.put("row","1000");
        params.put("search_2","model");
        Page<SkxdUserVo> page = skxdUserService.querySkxdUserPage(params);


        model.addAttribute("level", level);
        model.addAttribute("skxdUsers", page.getRows());



        return "skxdUserPower/to_select_area";
    }

    /**
     * 去选择客户
     *
     * @param userId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/toSelectCustom")
    public String toSelectCustom(String userId,ModelMap model) throws Exception {
        //查询当前用户的id
        model.addAttribute("userId", userId);
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        if (EmptyUtils.isEmpty(skxdUserPower)) {
            model.addAttribute("customIds", "");
        } else {
            model.addAttribute("customIds", skxdUserPower.getCustomId());
        }
        model.addAttribute("level",3);
        return "skxdUserPower/to_select_custom";
    }

    @RequestMapping("/toSelectDevice")
    public String toSelectDevice(String userId,ModelMap model) throws Exception {
        //查询当前用户的id
        model.addAttribute("userId", userId);
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        if (EmptyUtils.isEmpty(skxdUserPower)) {
            model.addAttribute("deviceIds", "");
        } else {
            model.addAttribute("deviceIds", skxdUserPower.getDeviceId());
        }
        model.addAttribute("level",4);
        return "skxdUserPower/to_select_device";
    }
    /**
     * 选择设备列表
     * @param paramDataTableVo
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/skxdDevicePage")
    @ResponseBody
    public DataTableVo skxdDevicePage(DataTableVo paramDataTableVo,String userId) throws Exception {
        DataTableVo dataTableVo = null;
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        params.put("customIds", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getCustomId())) ? new String[]{"000"} : skxdUserPower.getCustomId().split(","));
        if (EmptyUtils.isNotEmpty(paramDataTableVo.getsSearch_3())) {
            params.put("deviceIds", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getDeviceId())) ? new String[]{"000"} : skxdUserPower.getDeviceId().split(","));
        }
        Page page = skxdDeviceService.queryDevicePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }
    /**
     * 选择客户列表
     * @param paramDataTableVo
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/skxdCustomPage")
    @ResponseBody
    public DataTableVo skxdCustomPage(DataTableVo paramDataTableVo,String userId) throws Exception {
        DataTableVo dataTableVo = null;
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        params.put("areaNos", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getCityNo())) ? new String[]{"000"} : skxdUserPower.getCityNo().split(","));
        if (EmptyUtils.isNotEmpty(paramDataTableVo.getsSearch_1())) {
            params.put("customIds", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getCustomId())) ? new String[]{"000"} : skxdUserPower.getCustomId().split(","));
        }
        params.put("search_1","");
        params.put("isSelected",paramDataTableVo.getsSearch_1());
        Page page = skxdCustomService.queryCustomPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }
    /**
     * @param paramDataTableVo
     * @param level
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/skxdAreaPage")
    @ResponseBody
    public DataTableVo skxdAreaPage(DataTableVo paramDataTableVo, int level, String userId) throws Exception {
        DataTableVo dataTableVo = null;
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        params.put("level", level);
        //是否选择
        if (EmptyUtils.isNotEmpty(paramDataTableVo.getsSearch_1())) {
            if (level == 1) {
                params.put("areas", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getProvinceNo())) ? new String[]{"000"} : skxdUserPower.getProvinceNo().split(","));
            } else {
                params.put("areas", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getCityNo())) ? new String[]{"000"} : skxdUserPower.getCityNo().split(","));
            }
        }
        if (level == 2) {
            params.put("parents", (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getProvinceNo())) ? new String[]{"000"} : skxdUserPower.getProvinceNo().split(","));
        }
        Page page = skxdUserPowerService.querySkxdUserPowerPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }
    /**
     * @param level
     * @param value
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectArea")
    @ResponseBody
    public ReturnResult selectArea(HttpServletRequest request,int level, String value,final String userId) throws Exception {
        ReturnResult result = new ReturnResult();
        int flag = skxdUserPowerService.selectArea(level, value, userId);
        if (flag == 1) {
            //TODO   这里难道不是在扯淡？
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    HttpUtil.get("http://localhost:8081/skxd-client/client?method=loginOut&userId="+userId);
//                }
//            }).start();
            SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
            if(level==1){
                result.setData(skxdUserPower.getProvinceNo());
            }else if(level==2){
                result.setData(skxdUserPower.getCityNo());
            }else if(level==3){
                result.setData(skxdUserPower.getCustomId());
            }else{
                result.setData(skxdUserPower.getDeviceId());
            }
            result.setStatus(Constant.ReturnResult.STATUS.SUCCESS);
        }
        return flag == 1 ? result : ReturnResultUtil.returnFail();
    }

    /**
     * 删除区域
     *
     * @param level
     * @param value
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteArea")
    @ResponseBody
    public ReturnResult deleteArea(int level, String value, String userId) throws Exception {
        ReturnResult result = null;
        int flag = skxdUserPowerService.deleteArea(level, value, userId);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
            SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
            if(level==1){
                result.setData(skxdUserPower.getProvinceNo());
            }else if(level==2){
                result.setData(skxdUserPower.getCityNo());
            }else if(level==3){
                result.setData(skxdUserPower.getCustomId());
            }else{
                result.setData(skxdUserPower.getDeviceId());
            }
        }
        return result;
    }



    @RequestMapping("/templateConfig")
    @ResponseBody
    public ReturnResult templateConfig(HttpServletRequest request,final String userId,String modelUserId) throws Exception {
        skxdUserPowerService.templateConfig(userId,modelUserId);
        return ReturnResultUtil.returnSuccess();
    }


}
