package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.AccountSummary;
import com.enzamul.ngoProjects.repo.AccountRepo;
import com.enzamul.ngoProjects.repo.AccountSummaryRepo;
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
@RequestMapping(value = "/accSummary/")
public class AccountSummaryController {

  @Autowired
  private AccountSummaryRepo accountSummaryRepo;



    @Autowired
    private AccountRepo accountRepo;




    @GetMapping(value = "add")
    public String addAccountSummaryView(Model model) {
        model.addAttribute("accountSummary", new AccountSummary());

        model.addAttribute("accountList", this.accountRepo.findAll());

        return "accSummary/add";
    }


  @PostMapping(value = "add")
  public String addAccountSummary(@Valid AccountSummary accountSummary, BindingResult result, Model model){
      if(result.hasErrors()){
          return addAccountSummaryView(model);
      }else {
          if (accountSummary != null){
              AccountSummary accountSummary1 = this.accountSummaryRepo.findByAccount(accountSummary.getAccount());



              if (accountSummary1 != null){
                  model.addAttribute("existMsg", "AccountSummaryName is already exist");
              }else {
                  accountSummary.setTotalDepositAmountWithProfit(accountSummary.getTotalDepositAmount() + accountSummary.getProfitInDepositAmount());
                  if(accountSummary.getWidthrewDepositAmount() > accountSummary.getTotalDepositAmountWithProfit()){
                      model.addAttribute("existMsg", "Balance is in sufficient");
                      model.addAttribute("accountList", this.accountRepo.findAll());
                  }

                  accountSummary.setAvailableDepositAmount(accountSummary.getTotalDepositAmountWithProfit() - accountSummary.getWidthrewDepositAmount());

                  accountSummary.setNoOfLoanDue(accountSummary.getNoOfLoanTaken() - accountSummary.getNoOfLoanPaid());
                  accountSummary.setTotalLoanDueAmount(accountSummary.getTotalLoanAmount() - accountSummary.getTotalLoanPaidAmount());
                  accountSummary.setCurrentLoanDueAmount(accountSummary.getCurrentLoanAmount() - accountSummary.getCurrentLoanPaidAmount());

                  this.accountSummaryRepo.save(accountSummary);
                  model.addAttribute("accountSummary", new AccountSummary());
                  model.addAttribute("successMsg", "Data insert is Success");
              }
          }
      }
      return addAccountSummaryView(model);
  }


    @GetMapping(value = "/list")
    public String AccountSummaryList(Model model) {
        model.addAttribute("list", this.accountSummaryRepo.findAll());
        return "accSummary/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAccountSummaryView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("accountSummary", this.accountSummaryRepo.getOne(id));
        return "accSummary/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAccountSummary(@Valid AccountSummary accountSummary, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "accSummary/edit";
        } else {
            if (accountSummary != null) {
                /*
                   this.totalDepositAmount = totalDepositAmount;
        this.profitInDepositAmount = profitInDepositAmount;
        this.totalDepositAmountWithProfit = totalDepositAmountWithProfit;
        this.widthrewDepositAmount = widthrewDepositAmount;
        this.availableDepositAmount = availableDepositAmount;
        this.noOfLoanTaken = noOfLoanTaken;
        this.noOfLoanPaid = noOfLoanPaid;
        this.noOfLoanDue = noOfLoanDue;
        this.totalLoanAmount = totalLoanAmount;
        this.totalLoanPaidAmount = totalLoanPaidAmount;
        this.totalLoanDueAmount = totalLoanDueAmount;
        this.currentLoanAmount = currentLoanAmount;
        this.currentLoanPaidAmount = currentLoanPaidAmount;
        this.currentLoanDueAmount = currentLoanDueAmount;
        this.account = account;
                 */
                AccountSummary accountSummary1 = this.accountSummaryRepo.getOne(id);
                accountSummary1.setTotalDepositAmount(accountSummary.getTotalDepositAmount());
               accountSummary1.setProfitInDepositAmount(accountSummary.getProfitInDepositAmount());
               accountSummary1.setTotalDepositAmountWithProfit(accountSummary.getTotalDepositAmountWithProfit());
               accountSummary1.setWidthrewDepositAmount(accountSummary.getWidthrewDepositAmount());
               accountSummary1.setAvailableDepositAmount(accountSummary.getAvailableDepositAmount());
               accountSummary1.setNoOfLoanTaken(accountSummary.getNoOfLoanTaken());
               accountSummary1.setNoOfLoanPaid(accountSummary.getNoOfLoanPaid());
               accountSummary1.setNoOfLoanDue(accountSummary.getNoOfLoanDue());
               accountSummary1.setTotalLoanAmount(accountSummary.getTotalLoanAmount());
               accountSummary1.setTotalLoanPaidAmount(accountSummary.getTotalLoanPaidAmount());
               accountSummary1.setTotalLoanDueAmount(accountSummary.getTotalLoanDueAmount());
               accountSummary1.setCurrentLoanAmount(accountSummary.getCurrentLoanAmount());
               accountSummary1.setCurrentLoanPaidAmount(accountSummary.getCurrentLoanPaidAmount());
               accountSummary1.setCurrentLoanDueAmount(accountSummary.getCurrentLoanDueAmount());

                    this.accountSummaryRepo.save(accountSummary);
                    model.addAttribute("accountSummary", new AccountSummary());
                    model.addAttribute("successMsg", "Data Update is Success");
                }
            }

        return "redirect:/accSummary/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delAccountSummary(@PathVariable("id") Long id) {
        this.accountSummaryRepo.deleteById(id);
        return "redirect:/accSummary/list";

    }


}