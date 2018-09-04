package com.skxd.controller;
import com.skxd.model.SkxdAdminDictionary;
import com.skxd.model.SkxdAdminDictionaryExample;
import com.skxd.model.SkxdAdminDictionaryValue;
import com.skxd.model.SkxdMessage;
import com.skxd.service.ISkxdAdminDictionaryService;
import com.skxd.service.ISkxdAdminDictionaryValueService;
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

import java.util.List;
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdAdminDictionaryValue")
public class SkxdAdminDictionaryValueController {

    @Autowired
    private ISkxdAdminDictionaryValueService skxdAdminDictionaryValueService;

    @Autowired
    private ISkxdAdminDictionaryService skxdAdminDictionaryService;


    @RequestMapping("/toSkxdAdminDictionaryValuePage")
    public String toSkxdAdminDictionaryValuePage(String dId,ModelMap modelMap) throws Exception {
        SkxdAdminDictionaryExample skxdAdminDictionaryExample=new SkxdAdminDictionaryExample();
        List<SkxdAdminDictionary> skxdAdminDictionaryList=skxdAdminDictionaryService.querySkxdAdminDictionaryList(skxdAdminDictionaryExample);
        modelMap.addAttribute("skxdAdminDictionaryList",skxdAdminDictionaryList);
        modelMap.addAttribute("dId",dId);
        return "skxdAdminDictionaryValue/skxd_admin_dictionary_value_page";
    }

    @RequestMapping("/skxdAdminDictionaryValuePage")
    @ResponseBody
    public DataTableVo skxdAdminDictionaryValuePage(DataTableVo paramDataTableVo,String dId) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        params.put("dId",dId);
        Page page = skxdAdminDictionaryValueService.querySkxdAdminDictionaryValuePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdAdminDictionaryValue")
    public String toAddSkxdAdminDictionaryValue(ModelMap model,String dId) throws Exception {
        SkxdAdminDictionaryValue skxdAdminDictionaryValue=new SkxdAdminDictionaryValue();
        SkxdAdminDictionaryExample skxdAdminDictionaryExample=new SkxdAdminDictionaryExample();
        List<SkxdAdminDictionary> skxdAdminDictionaryList=skxdAdminDictionaryService.querySkxdAdminDictionaryList(skxdAdminDictionaryExample);
        model.addAttribute("skxdAdminDictionaryValue",skxdAdminDictionaryValue);
        model.addAttribute("skxdAdminDictionaryList",skxdAdminDictionaryList);
        model.addAttribute("dId",dId);
        return "skxdAdminDictionaryValue/to_edit_skxd_admin_dictionary_value";
    }

    @RequestMapping("/saveOrUpdateSkxdAdminDictionaryValue")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdAdminDictionaryValue(SkxdAdminDictionaryValue skxdAdminDictionaryValue) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminDictionaryValueService.saveOrUpdateSkxdAdminDictionaryValue(skxdAdminDictionaryValue);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdAdminDictionaryValueByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminDictionaryValueByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminDictionaryValueService.removeSkxdAdminDictionaryValueByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdAdminDictionaryValue")
    public String toUpdateSkxdAdminDictionaryValue(String id, ModelMap model) throws Exception {
        SkxdAdminDictionaryValue skxdAdminDictionaryValue = skxdAdminDictionaryValueService.querySkxdAdminDictionaryValueById(id);
        SkxdAdminDictionaryExample skxdAdminDictionaryExample=new SkxdAdminDictionaryExample();
        List<SkxdAdminDictionary> skxdAdminDictionaryList=skxdAdminDictionaryService.querySkxdAdminDictionaryList(skxdAdminDictionaryExample);
        model.addAttribute("skxdAdminDictionaryValue",skxdAdminDictionaryValue);
        model.addAttribute("skxdAdminDictionaryList",skxdAdminDictionaryList);
        return "skxdAdminDictionaryValue/to_edit_skxd_admin_dictionary_value";
    }
}
