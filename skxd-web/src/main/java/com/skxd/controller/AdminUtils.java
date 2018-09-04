package com.skxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shang-pc on 2016/6/29.
 */
@Controller
@RequestMapping("/admin/util")
public class AdminUtils {

    @RequestMapping("/toShowPicture")
    public String toShowPicture(){
        return "utils/toShowPicture";
    }
}
