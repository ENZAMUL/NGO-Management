package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.entity.Withdraw;
import com.enzamul.ngoProjects.repo.AccountRepo;
import com.enzamul.ngoProjects.repo.EmployeeRepo;
import com.enzamul.ngoProjects.repo.WithdrawRepo;
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
@RequestMapping(value = "/withdraw/")
public class WithdrawController {

    @Autowired
    private WithdrawRepo withdrawRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value = "add")
    public String addWithdrawView(Model model) {
        model.addAttribute("withdraw", new Withdraw());

        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("employeeList", this.employeeRepo.findAll());

        return "withdraw/add";
    }

    @PostMapping(value = "add")
    public String addWithdraw(@Valid Withdraw withdraw, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addWithdrawView(model);
        } else {
            if (withdraw != null) {
                Withdraw withdraw1 = this.withdrawRepo.findByAccount(withdraw.getAccount());
                if (withdraw1 != null) {
                    model.addAttribute("existMsg", "WithdrawName is already exist");
                } else {
                    this.withdrawRepo.save(withdraw);
                    model.addAttribute("withdraw", new Withdraw());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addWithdrawView(model);
    }

    @GetMapping(value = "/list")
    public String WithdrawList(Model model) {
        model.addAttribute("list", this.withdrawRepo.findAll());
        return "withdraw/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editWithdrawView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("withdraw", this.withdrawRepo.getOne(id));
        return "withdraw/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editWithdraw(@Valid Withdraw withdraw, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "withdraw/edit";
        } else {
            if (withdraw != null) {
                /*
                    this.amount = amount;
        this.withdrawDate = withdrawDate;
        this.employee = employee;
        this.account = account;
                 */
                Withdraw withdraw1 = this.withdrawRepo.getOne(id);
                withdraw1.setAmount(withdraw.getAmount());
                withdraw1.setWithdrawDate(withdraw.getWithdrawDate());
                withdraw1.setEmployee(withdraw.getEmployee());
                withdraw1.setAccount(withdraw.getAccount());

                this.withdrawRepo.save(withdraw1);
                model.addAttribute("withdraw", new Withdraw());
                model.addAttribute("successMsg", "Data Update is Success");
            }
        }

        return "redirect:/withdraw/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delWithdraw(@PathVariable("id") Long id) {
        this.withdrawRepo.deleteById(id);
        return "redirect:/withdraw/list";

    }

}
