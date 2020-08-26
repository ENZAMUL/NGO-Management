package com.enzamul.ngoProjects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author MD ENZAMUL HOQ
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayIndex(){
        return "dashboard";
    }



    @GetMapping(value = "/about")
    public String displayAbout(){
        return "about";
    }



    @GetMapping(value = "/dashboard")
    public String displayLeft(){
        return "dashboard";
    }
}
