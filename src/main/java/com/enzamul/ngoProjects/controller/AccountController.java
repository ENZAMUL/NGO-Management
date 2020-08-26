package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.entity.Account;
import com.enzamul.ngoProjects.repo.AccountRepo;
import com.enzamul.ngoProjects.repo.AccountTypeRepo;
import com.enzamul.ngoProjects.repo.BranchRepo;
import com.enzamul.ngoProjects.repo.NomineeRepo;
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
@RequestMapping(value = "/account/")
public class AccountController {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private NomineeRepo nomineeRepo;

    @GetMapping(value = "add")
    public String addAccountView(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("accountList", this.accountRepo.findAll());

        model.addAttribute("accountTypeList", this.accountTypeRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("nomineeList", this.nomineeRepo.findAll());
        return "account/add";
    }

    @PostMapping(value = "add")
    public String addAccount(@Valid Account account, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addAccountView(model);
        } else {
            if (account != null) {
                Account account1 = this.accountRepo.findByAccountHolderName(account.getAccountHolderName());
                if (account1 != null) {
                    model.addAttribute("existMsg", "AccountName is already exist");
                } else {
                    this.accountRepo.save(account);
                    model.addAttribute("account", new Account());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addAccountView(model);
    }

    @GetMapping(value = "/list")
    public String AccountList(Model model) {
        model.addAttribute("list", this.accountRepo.findAll());
        return "account/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editAccountView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("account", this.accountRepo.getOne(id));
        return "account/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAccount(@Valid Account account, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "account/edit";
        } else {
            if (account != null) {
                Account account1 = this.accountRepo.getOne(id);
                /*
                  this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountCodeNumber = accountCodeNumber;
        this.primaryDepositAmount = primaryDepositAmount;
        this.totalWithdraw = totalWithdraw;
        this.balanceAmount = balanceAmount;
        this.birthDate = birthDate;
        this.accountHolderAge = accountHolderAge;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.nidNumber = nidNumber;
        this.profession = profession;
        this.accountOpeningDate = accountOpeningDate;
        this.accountType = accountType;
        this.branch = branch;
        this.nominees = nominees;
                 */
                account1.setAccountHolderName(account.getAccountHolderName());
                account1.setAccountNumber(account.getAccountNumber());
                account1.setAccountCodeNumber(account.getAccountCodeNumber());
                account1.setPrimaryDepositAmount(account.getPrimaryDepositAmount());
                account1.setTotalWithdraw(account.getTotalWithdraw());
                account1.setBalanceAmount(account.getBalanceAmount());
                account1.setBirthDate(account.getBirthDate());
                account1.setAccountHolderAge(account.getAccountHolderAge());
                account1.setGender(account.getGender());
                account1.setEmail(account.getEmail());
                account1.setMobile(account.getMobile());
                account1.setAddress(account.getAddress());
                account1.setNidNumber(account.getNidNumber());
                account1.setProfession(account.getProfession());
                account1.setAccountOpeningDate(account.getAccountOpeningDate());
                account1.setAccountType(account.getAccountType());
                account1.setBranch(account.getBranch());
                account1.setNominees(account.getNominees());

                this.accountRepo.save(account);
                model.addAttribute("account", new Account());
                model.addAttribute("successMsg", "Update Successfully");
            }
        }

        return "redirect:/account/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delAccount(@PathVariable("id") Long id) {
        this.accountRepo.deleteById(id);
        return "redirect:/account/list";

    }

}
