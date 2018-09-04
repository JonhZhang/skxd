package com.skxd.controller;

import com.skxd.model.SkxdAdminModule;
import com.skxd.model.SkxdAdminRole;
import com.skxd.model.SkxdAdminUser;
import com.skxd.service.ISkxdAdminModuleService;
import com.skxd.service.ISkxdAdminRoleModuleService;
import com.skxd.vo.DataTableVo;
import com.skxd.vo.NodeVo;
import com.skxd.vo.SkxdAdminModuleVo;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>模块controller</p>
 * <p/> 测试检出
 * Created by zzshang on 2015/10/27.
 */
@Controller
@RequestMapping(value = "/admin/adminModule")
public class AdminSkxdModuleController {

    @Autowired
    private ISkxdAdminModuleService skxdAdminModuleService;

    @Autowired
    private ISkxdAdminRoleModuleService skxdAdminRoleService;

    @Autowired
    private GenericDAOImpl genericDAO;

    /**
     * 查询模块的分页
     *
     * @return
     */
    @RequestMapping("/adminModulePage")
    @ResponseBody
    public DataTableVo querySkxdAdminModulePage(DataTableVo paramDataTableVo) throws Exception {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdAdminModule> page = skxdAdminModuleService.querySkxdAdminModulePage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    /**
     * 模块列表页
     *
     * @return
     */
    @RequestMapping("/toAdminModulePage")
    public String toAdminModulePage() {
        return "admin_module/admin_module_page";
    }

    /**
     * 添加模块页面
     *
     * @return
     */
    @RequestMapping("/toAddAdminModule")
    public String toAddModule(ModelMap model) throws Exception {
        List<SkxdAdminModule> skxdAdminModuleList = skxdAdminModuleService.querySkxdAdminModuleByLevel(1);
        model.put("adminModule", new SkxdAdminModule());
        model.put("adminModuleList", skxdAdminModuleList);
        return "admin_module/to_update_admin_module";
    }

    /**
     * 保存或者更新模块信息
     *
     * @param skxdAdminModule
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveOrUpdateAdminModule")
    @ResponseBody
    public ReturnResult saveOrUpdateModule(SkxdAdminModule skxdAdminModule) throws Exception {
        ReturnResult result = null;
        int flag = skxdAdminModuleService.saveOrUpdateModule(skxdAdminModule);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    /**
     * 根据级别查询模块列表
     *
     * @return
     */
    @RequestMapping("/querySkxdAdminModuleListByLevel")
    @ResponseBody
    public ReturnResult querySkxdAdminModuleListByLevel(Integer level) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        List<SkxdAdminModule> skxdAdminModuleList = skxdAdminModuleService.querySkxdAdminModuleByLevel(level);
        result.setData(skxdAdminModuleList);
        return result;
    }

    /**
     * 删除模块
     *
     * @param ids
     * @return
     */
    @RequestMapping("/removeAdminModuleByIds")
    @ResponseBody
    public ReturnResult removeSkxdAdminModuleByIds(String ids) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        int flag = skxdAdminModuleService.removeByIds(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    /**
     * 删除模块
     *
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateAdminModule")
    public String toModifySkxdAdminModule(String id, ModelMap model) throws Exception {
        SkxdAdminModule skxdAdminModule = skxdAdminModuleService.querySkxdAdminModuleById(id);
        List<SkxdAdminModule> skxdAdminModuleList = skxdAdminModuleService.querySkxdAdminModuleByLevel(1);
        model.put("adminModule", skxdAdminModule);
        model.put("adminModuleList", skxdAdminModuleList);
        return "admin_module/to_update_admin_module";
    }

    @RequestMapping("/queryModuleToTree")
    @ResponseBody
    public ReturnResult queryModuleByTree(String roleId) throws Exception {
        ReturnResult result = ReturnResultUtil.returnSuccess();
        List<NodeVo> nodeVoList = skxdAdminModuleService.queryTreeNode(roleId);
        result.setData(nodeVoList);
        return result;
    }

    @RequestMapping("/querySkxdAdminModulelist")
    @ResponseBody
    public Map querySkxdAdminModuleVo() throws Exception {
        Map params=new HashMap();
        SkxdAdminRole skxdAdminRole= (SkxdAdminRole)  SecurityUtils.getSubject().getSession().getAttribute("role");
        params.put("roleId",skxdAdminRole.getId());
        params.put("level",1);
        List<SkxdAdminModule> skxdAdminModules=genericDAO.list("MODULE.getSkxdAdminModuleByRole",params);
        List<SkxdAdminModuleVo> skxdAdminModuleVoList=new ArrayList<SkxdAdminModuleVo>();
        if(EmptyUtils.isNotEmpty(skxdAdminModules)){
            for(SkxdAdminModule skxdAdminModule:skxdAdminModules){
                SkxdAdminModuleVo skxdAdminModuleVo=new SkxdAdminModuleVo();
                BeanUtils.copyProperties(skxdAdminModule, skxdAdminModuleVo);
                params.put("level",2);
                params.put("parent",skxdAdminModule.getId());
                List<SkxdAdminModule> children = genericDAO.list("MODULE.getSkxdAdminModuleByRole",params);
                skxdAdminModuleVo.setChildren(children);
                skxdAdminModuleVoList.add(skxdAdminModuleVo);
            }
        }
        Map result=new HashMap();
        result.put("status",true);
        result.put("data",skxdAdminModuleVoList);
        return result;
    }
}
