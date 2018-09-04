package com.skxd.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skxd.model.SkxdRole;
import com.skxd.service.impl.SkxdRoleService;
/**
 * 
 * @author taohuabi
 *
 */
@Controller
@RequestMapping(value = "/role")
public class SkxdRoleController {

    @Autowired
    private SkxdRoleService skxdRoleService;

    
    @RequestMapping("/findAll")
    @ResponseBody
    public List<SkxdRole> findAll(){
    	return skxdRoleService.findAll();
    }
}
