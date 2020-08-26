package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.entity.User;
import com.enzamul.ngoProjects.repo.RoleRepo;
import com.enzamul.ngoProjects.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "add")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "user/add";
    }

    @PostMapping(value = "add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roleList", this.roleRepo.findAll());
            return addUserView(model);
        } else {
            if (user != null) {
                User user1 = this.userRepo.findByUsername(user.getUsername());
                if (user1 != null) {
                    model.addAttribute("existMsg", "UserName is already exist");
                } else {
                    user.setStatus(true);
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    user.setConformationToken(UUID.randomUUID().toString());
                    this.userRepo.save(user);
                    model.addAttribute("user", new User());
                    model.addAttribute("roleList", this.roleRepo.findAll());
                    model.addAttribute("successMsg", "Congratulation Data Insert Success");
                }
            }
        }
        return addUserView(model);
    }

    @GetMapping(value = "/list")
    public String userList(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "user/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUserView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        return "user/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@Valid User user, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/edit";
        } else {
            if (user != null) {
                /*
                   this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.regiDate = regiDate;
        this.email = email;
        this.mobile = mobile;
        this.lastModifiedDate = lastModifiedDate;
        this.password = password;
        this.status = status;
        this.conformationToken = conformationToken;
        this.roles = roles;
                 */
                User user1 = this.userRepo.getOne(id);
                user1.setUsername(user.getUsername());
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                user1.setBirthDate(user.getBirthDate());
                user1.setAge(user.getAge());
                user1.setGender(user.getGender());
                user1.setAddress(user.getAddress());
                user1.setRegiDate(user.getRegiDate());
                user1.setEmail(user.getEmail());
                user1.setMobile(user.getMobile());
                user1.setLastModifiedDate(user.getLastModifiedDate());
                user1.setPassword(user.getPassword());
                user1.setStatus(user.isStatus());
                user1.setConformationToken(user.getConformationToken());
                user1.setRoles(user.getRoles());

                this.userRepo.save(user1);
                model.addAttribute("user", new User());
                model.addAttribute("successMsg", "Update Successfully ");
            }
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id) {
        this.userRepo.deleteById(id);
        return "redirect:/user/list";

    }

}
