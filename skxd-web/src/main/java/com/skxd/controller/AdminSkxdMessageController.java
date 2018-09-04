package com.skxd.controller;
import com.skxd.model.SkxdMessage;
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
import java.util.Map;


/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
@RequestMapping("/admin/skxdMessage")
public class AdminSkxdMessageController {

    @Autowired
    private ISkxdMessageService skxdMessageService;


    @RequestMapping("/toSkxdMessagePage")
    public String toSkxdMessagePage() {
        return "skxdMessage/skxd_message_page";
    }

    @RequestMapping("/skxdMessagePage")
    @ResponseBody
    public DataTableVo skxdMessagePage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page page = skxdMessageService.querySkxdMessagePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping("/toAddSkxdMessage")
    public String toAddSkxdMessage(ModelMap model) {
        SkxdMessage skxdMessage=new SkxdMessage();
        model.addAttribute("skxdMessage",skxdMessage);
        return "skxdMessage/to_edit_skxd_message";
    }

    @RequestMapping("/saveOrUpdateSkxdMessage")
    @ResponseBody
    public ReturnResult saveOrUpdateSkxdMessage(SkxdMessage skxdMessage) throws Exception {
        ReturnResult result = null;
        int flag = skxdMessageService.saveOrUpdateSkxdMessage(skxdMessage);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/removeSkxdMessageByIds")
    @ResponseBody
    public ReturnResult removeSkxdMessageByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdMessageService.removeSkxdMessageByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail();
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/toUpdateSkxdMessage")
    public String toUpdateSkxdMessage(String id, ModelMap model) throws Exception {
        SkxdMessage skxdMessage = skxdMessageService.querySkxdMessageById(id);
        model.addAttribute("skxdMessage", skxdMessage);
        return "skxdMessage/to_edit_skxd_message";
    }
}
