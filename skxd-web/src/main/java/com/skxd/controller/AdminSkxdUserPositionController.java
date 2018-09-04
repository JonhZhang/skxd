package com.skxd.controller;
import com.skxd.model.SkxdUserPosition;
import com.skxd.service.ISkxdUserPositionService;
import com.skxd.vo.DataTableVo;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdUserPosition")
public class AdminSkxdUserPositionController {

    @Autowired
    private ISkxdUserPositionService skxdUserPositionService;


    @RequestMapping("/toSkxdUserPositionPage")
    public String toSkxdUserPositionPage(String userId,ModelMap modelMap) {
        modelMap.addAttribute("userId","1161D9CD24BD4A94A5108B0EBFA127BF");
        return "skxdUserPosition/skxd_user_position_page";
    }

    @RequestMapping("/toSkxdUserPositionMapIframe")
    public String toSkxdUserPositionMapIframe(String userId, ModelMap modelMap, HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        modelMap.addAttribute("userId",userId);
        modelMap.addAttribute("basePath",basePath);
        return "skxdUserPosition/skxd_user_position_iframe";
    }


    @RequestMapping("/toSkxdUserPositionMap")
    public String toSkxdUserPositionMap(String userId,ModelMap modelMap) {
        modelMap.addAttribute("userId",userId);
        return "skxdUserPosition/skxd_user_position_map";
    }

    @RequestMapping("/queryListByMap")
    @ResponseBody
    public ReturnResult queryListByMap(@RequestParam(value ="startDate") @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate, @RequestParam(value ="endDate") @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate, String userId) throws Exception {
        ReturnResult returnResult=ReturnResultUtil.returnSuccess();
        List<SkxdUserPosition> userPositionList=skxdUserPositionService.querySkxdUserPositionList(startDate,endDate,userId);
        returnResult.setData(userPositionList);
        return returnResult;
    }

    @RequestMapping("/skxdUserPositionPage")
    @ResponseBody
    public DataTableVo skxdUserPositionPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdUserPositionService.querySkxdUserPositionPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdUserPosition")
    public String toAddSkxdUserPosition(ModelMap model) {
        return "skxdUserPosition/to_edit_skxdUserPosition";
    }

    @RequestMapping("/saveOrUpdateSkxdUserPosition")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdUserPosition(SkxdUserPosition skxdUserPosition) throws Exception {
        ReturnResult result = null;
        int flag = skxdUserPositionService.saveOrUpdateSkxdUserPosition(skxdUserPosition);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdUserPositionByIds")
    @ResponseBody
    public ReturnResult removeSkxdUserPositionByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdUserPositionService.removeSkxdUserPositionByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdUserPosition")
    public String toUpdateSkxdUserPosition(String id, ModelMap model) throws Exception {
        SkxdUserPosition skxdUserPosition = skxdUserPositionService.querySkxdUserPositionById(id);
        model.addAttribute("skxdUserPosition", skxdUserPosition);
        return "skxdUserPosition/to_edit_skxd_user_position";
    }
}
