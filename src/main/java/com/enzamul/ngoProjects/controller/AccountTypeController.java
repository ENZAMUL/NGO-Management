package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.AccountType;
import com.enzamul.ngoProjects.repo.AccountTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
/**
 *
 * @author MD ENZAMUL HOQ
 */
@Controller
@RequestMapping(value = "/accType/")
public class AccountTypeController {

    @Autowired
    private AccountTypeRepo repo;

    @GetMapping(value = "add")
    public String addAccountTypeView(Model model) {
        model.addAttribute("accountType", new AccountType());
        return "accType/add";

    }

    @PostMapping(value = "add")
    public String addAccountType(@Valid AccountType accountType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addAccountTypeView(model);
        } else {
            if (accountType != null) {
                AccountType accountType1 = this.repo.findByTypeName(accountType.getTypeName());
                if (accountType1 != null) {
                    model.addAttribute("existMsg", "AccountTypeName is already exist");
                } else {
                    this.repo.save(accountType);
                    model.addAttribute("accountType", new AccountType());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addAccountTypeView(model);
    }

    @GetMapping(value = "/list")
    public String AccountTypeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "accType/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editAccountTypeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("accountType", this.repo.getOne(id));
        return "accType/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAccountType(@Valid AccountType accountType, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "accType/edit";
        } else {
            if (accountType != null) {
                AccountType accountType1 = this.repo.getOne(id);
                accountType1.setTypeName(accountType.getTypeName());


                    this.repo.save(accountType1);
                    model.addAttribute("accountType", new AccountType());
                    model.addAttribute("successMsg", "Update Successfully");
                }
            }

        return "redirect:/accType/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delAccountType(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/accType/list";

    }
}
