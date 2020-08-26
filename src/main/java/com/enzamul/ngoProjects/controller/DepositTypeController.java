package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.entity.DepositType;
import com.enzamul.ngoProjects.repo.DepositTypeRepo;
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
@RequestMapping(value = "/depType/")
public class DepositTypeController {

    @Autowired
    private DepositTypeRepo repo;

    @GetMapping(value = "add")
    public String addDepositTypeView(Model model) {
        model.addAttribute("depositType", new DepositType());
        return "depType/add";

    }

    @PostMapping(value = "add")
    public String addDepositType(@Valid DepositType depositType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addDepositTypeView(model);
        } else {
            if (depositType != null) {
                DepositType depositType1 = this.repo.findByTypeName(depositType.getTypeName());
                if (depositType1 != null) {
                    model.addAttribute("existMsg", "DepositTypeName is already exist");
                } else {
                    this.repo.save(depositType);
                    model.addAttribute("depositType", new DepositType());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addDepositTypeView(model);
    }

    @GetMapping(value = "/list")
    public String DepositTypeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "depType/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editDepositTypeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("depositType", this.repo.getOne(id));
        return "depType/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDepositType(@Valid DepositType depositType, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "depType/edit";
        } else {
            if (depositType != null) {
                DepositType depositType1 = this.repo.getOne(id);
                depositType1.setTypeName(depositType.getTypeName());

                this.repo.save(depositType1);
                model.addAttribute("depositType", new DepositType());
                model.addAttribute("successMsg", "Update Successfully");
            }
        }

        return "redirect:/depType/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delDepositType(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/depType/list";

    }
}
