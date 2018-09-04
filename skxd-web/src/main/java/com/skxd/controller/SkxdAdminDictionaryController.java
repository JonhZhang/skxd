package com.skxd.controller;
import com.skxd.model.SkxdAdminDictionary;
import com.skxd.service.ISkxdAdminDictionaryService;
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
@RequestMapping("/admin/skxdAdminDictionary")
public class SkxdAdminDictionaryController {

    @Autowired
    private ISkxdAdminDictionaryService skxdAdminDictionaryService;


    @RequestMapping("/toSkxdAdminDictionaryPage")
    public String toSkxdAdminDictionaryPage() {
        return "skxdAdminDictionary/skxd_admin_dictionary_page";
    }

    @RequestMapping("/skxdAdminDictionaryPage")
    @ResponseBody
    public DataTableVo skxdAdminDictionaryPage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdAdminDictionaryService.querySkxdAdminDictionaryPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdAdminDictionary")
    public String toAddSkxdAdminDictionary(ModelMap model) {
        SkxdAdminDictionary skxdAdminDictionary=new SkxdAdminDictionary();
        model.addAttribute("skxdAdminDictionary",skxdAdminDictionary);
        return "skxdAdminDictionary/to_edit_skxd_admin_dictionary";
    }

    @RequestMapping("/saveOrUpdateSkxdAdminDictionary")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdAdminDictionary(SkxdAdminDictionary skxdAdminDictionary) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminDictionaryService.saveOrUpdateSkxdAdminDictionary(skxdAdminDictionary);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdAdminDictionaryByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminDictionaryByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminDictionaryService.removeSkxdAdminDictionaryByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdAdminDictionary")
    public String toUpdateSkxdAdminDictionary(String id, ModelMap model) throws Exception {
        SkxdAdminDictionary skxdAdminDictionary = skxdAdminDictionaryService.querySkxdAdminDictionaryById(id);
        model.addAttribute("skxdAdminDictionary", skxdAdminDictionary);
        return "skxdAdminDictionary/to_edit_skxd_admin_dictionary";
    }
}
