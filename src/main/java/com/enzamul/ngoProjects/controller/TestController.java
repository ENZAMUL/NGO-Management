package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.repo.UserRepo;
import com.enzamul.ngoProjects.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Controller
public class TestController {

    @Autowired
    private UserRepo userRepo;

    @ResponseBody
    @GetMapping(value = "/test")
    public User restApi() {
        return userRepo.findByUsername("admin");
    }
}
