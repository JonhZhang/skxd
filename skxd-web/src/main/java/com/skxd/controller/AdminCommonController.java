package com.skxd.controller;

import java.util.List;

import com.skxd.service.impl.SkxdAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.skxd.model.SkxdArea;
/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/29.
 */
@Controller
@RequestMapping("/admin/common")
public class AdminCommonController {
	@Autowired
	private SkxdAreaService areaService;

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
    
    @RequestMapping("/findCityByParent/{parent}")
    @ResponseBody
    public List<SkxdArea> findCityByParent(@PathVariable String parent){
    	return 	areaService.findCityByParent(parent);
    }
    
}
