package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.LoanType;
import com.enzamul.ngoProjects.repo.LoanTypeRepo;
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
@RequestMapping(value = "/loanType/")
public class LoanTypeController {

    @Autowired
    private LoanTypeRepo repo;

    @GetMapping(value = "add")
    public String addLoanTypeView(Model model) {
        model.addAttribute("loanType", new LoanType());
        return "loanType/add";

    }

    @PostMapping(value = "add")
    public String addLoanType(@Valid LoanType loanType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addLoanTypeView(model);
        } else {
            if (loanType != null) {
                LoanType loanType1 = this.repo.findByTypeName(loanType.getTypeName());
                if (loanType1 != null) {
                    model.addAttribute("existMsg", "LoanTypeName is already exist");
                } else {
                    this.repo.save(loanType);
                    model.addAttribute("loanType", new LoanType());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addLoanTypeView(model);
    }

    @GetMapping(value = "/list")
    public String LoanTypeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "loanType/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editLoanTypeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("loanType", this.repo.getOne(id));
        return "loanType/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editLoanType(@Valid LoanType loanType, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "loanType/edit";
        } else {
            if (loanType != null) {
                LoanType loanType1 = this.repo.getOne(id);
               loanType1.setTypeName(loanType.getTypeName());


                    this.repo.save(loanType1);
                    model.addAttribute("loanType", new LoanType());
                    model.addAttribute("successMsg", "Update Successfully");
                }
            }

        return "redirect:/loanType/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delLoanType(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/loanType/list";

    }
}
