package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.entity.Deposit;
import com.enzamul.ngoProjects.repo.AccountRepo;
import com.enzamul.ngoProjects.repo.DepositRepo;
import com.enzamul.ngoProjects.repo.DepositTypeRepo;
import com.enzamul.ngoProjects.repo.EmployeeRepo;
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
@RequestMapping(value = "/deposit/")
public class DepositController {

    @Autowired
    private DepositRepo depositRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private DepositTypeRepo depositTypeRepo;

    @GetMapping(value = "add")
    public String addDepositView(Model model) {
        model.addAttribute("deposit", new Deposit());

        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("depositTypeList", this.depositTypeRepo.findAll());
        return "deposit/add";
    }

    @PostMapping(value = "add")
    public String addDeposit(@Valid Deposit deposit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addDepositView(model);
        } else {
            if (deposit != null) {
                boolean alreadyExists = this.depositRepo.existsByLoanCodeNumber(deposit.getLoanCodeNumber());
                if (alreadyExists) { 
                    model.addAttribute("existMsg", "DepositName is already exist");
                } else {
                    this.depositRepo.save(deposit);
                    model.addAttribute("deposit", new Deposit());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addDepositView(model);
    }

    @GetMapping(value = "/list")
    public String DepositList(Model model) {
        model.addAttribute("list", this.depositRepo.findAll());
        return "deposit/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editDepositView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("deposit", this.depositRepo.getOne(id));
        return "deposit/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDeposit(@Valid Deposit deposit, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "deposit/edit";
        } else {
            if (deposit != null) {
                /*
                 this.depositBranch = depositBranch;
        this.loanCodeNumber = loanCodeNumber;
        this.depositDate = depositDate;
        this.amount = amount;
        this.employee = employee;
        this.account = account;
        this.depositType = depositType;
                 */
                Deposit deposit1 = this.depositRepo.getOne(id);
                deposit1.setDepositBranch(deposit.getDepositBranch());
                deposit1.setLoanCodeNumber(deposit.getLoanCodeNumber());
                deposit1.setDepositDate(deposit.getDepositDate());
                deposit1.setAmount(deposit.getAmount());
                deposit1.setEmployee(deposit.getEmployee());
                deposit1.setAccount(deposit.getAccount());
                deposit1.setDepositType(deposit.getDepositType());

                this.depositRepo.save(deposit1);
                model.addAttribute("deposit", new Deposit());
                model.addAttribute("successMsg", "Update Successfully");
            }
        }

        return "redirect:/deposit/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delDeposit(@PathVariable("id") Long id) {
        this.depositRepo.deleteById(id);
        return "redirect:/deposit/list";

    }

}
