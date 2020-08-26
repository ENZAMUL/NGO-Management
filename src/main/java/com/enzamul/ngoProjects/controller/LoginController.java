package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.User;
import com.enzamul.ngoProjects.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author MD ENZAMUL HOQ
 */
@Controller
public class LoginController {


    @Autowired
    private RoleRepo roleRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){
        return "redirect:/";
    }
    return "login";

    }

    @GetMapping(value = "/access-denied")
    public String accessDenied(){
        return "access-denied";
    }


    @GetMapping(value = "/signup")
    public String viewSignUp(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "signup";
    }
}
