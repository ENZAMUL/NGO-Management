package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.repo.BranchRepo;
import com.enzamul.ngoProjects.repo.EmployeeRepo;
import com.enzamul.ngoProjects.repo.WithdrawRepo;
import com.enzamul.ngoProjects.repo.LoanRepo;
import com.enzamul.ngoProjects.repo.DepositRepo;
import com.enzamul.ngoProjects.repo.LoanCollectionRepo;
import com.enzamul.ngoProjects.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author MD ENZAMUL HOQ
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {
    //Deposit Summary
    @Autowired
    private DepositRepo depositRepo;
    double totalAmount = 0.0;

    @GetMapping(value = "totaldepositamount")
    public String getTotalDeposit(Model model) {
        totalAmount = 0.0;
        this.depositRepo.findAll().forEach((dep) -> {
            totalAmount += dep.getAmount();
        });
        model.addAttribute("list", this.depositRepo.findAll());
        model.addAttribute("totalAmount", totalAmount);
        return "reports/totaldeposit";
    }


    //Loan Summary
    @Autowired
    private LoanRepo loanRepo;
    double totaldisloanAmount = 0.0;

    @GetMapping(value = "distributedloan")
    public String getTotalLoanAmount(Model model) {
        totaldisloanAmount = 0.0;
        this.loanRepo.findAll().forEach((loan) -> {
            totaldisloanAmount += loan.getLoanAmount();
        });
        model.addAttribute("list", this.loanRepo.findAll());
        model.addAttribute("totaldisloanAmount", totaldisloanAmount);
        return "reports/loanamount";
    }


    // Branch Report Summary
    @Autowired
    private BranchRepo branchRepo;
    int numberOfBranch = 0;

    @GetMapping(value = "numberOfBranch")
    public String getNumberOfBranch(Model model) {

        numberOfBranch = 0;
        //this.branchRepo.findAll().size();
        model.addAttribute("list", this.branchRepo.findAll());

        model.addAttribute("numberOfBranch", this.branchRepo.findAll().size());

        return "reports/numberofbranch";
    }


    // Employee Report Summary
    @Autowired
    private EmployeeRepo employeeRepo;
    int numberOfTotalEmployee = 0;

    @GetMapping(value = "numberOfEmployee")
    public String getNumberOfEmployee(Model model) {

        numberOfTotalEmployee = 0;
        model.addAttribute("list", this.employeeRepo.findAll());

        model.addAttribute("numberOfTotalEmployee", this.employeeRepo.findAll().size());

        return "reports/numberofemployee";
    }


    // Account Report Summary
    @Autowired
    private AccountRepo accountRepo;
    int numberOfAccount = 0;

    @GetMapping(value = "numberOfAccount")
    public String getNumberOfAccount(Model model) {

        numberOfAccount = 0;
        model.addAttribute("list", this.accountRepo.findAll());

        model.addAttribute("numberOfAccount", this.accountRepo.findAll().size());

        return "reports/numberofaccount";
    }


    //Loan Collection Summary
    @Autowired
    private LoanCollectionRepo loanCollectionRepo;
    double totalAmountOfNgo = 0.0;
    double collectionOfTotalKisti = 0.0;
    double collectedOfLoanAmount = 0.0;

    /*
     this.ngoOfTotalAmount = ngoOfTotalAmount;
        this.collectedKistiNo = collectedKistiNo;
        this.ngoOfCollectedAmount = ngoOfCollectedAmount;
     */

    @GetMapping(value = "collectionLoanSummary")
    public String getTotalLoanCollection(Model model) {
        totalAmountOfNgo = 0.0;
        collectionOfTotalKisti = 0.0;
        collectedOfLoanAmount = 0.0;
        this.loanCollectionRepo.findAll().forEach((loancoll) -> {
            totalAmountOfNgo += loancoll.getNgoOfTotalAmount();
            collectionOfTotalKisti += loancoll.getCollectedKistiNo();
            collectedOfLoanAmount += loancoll.getNgoOfCollectedAmount();

        });
        model.addAttribute("list", this.loanCollectionRepo.findAll());
        model.addAttribute("totalAmountOfNgo", totalAmountOfNgo);
        model.addAttribute("collectionOfTotalKisti", collectionOfTotalKisti);
        model.addAttribute("collectedOfLoanAmount", collectedOfLoanAmount);
        return "reports/collectloansummary";
    }


    //Withdrow Summary
    @Autowired
    private WithdrawRepo withdrawRepo;
    double totalWithdrawAmount = 0.0;

    @GetMapping(value = "withdrawAmount")
    public String getTotalWithdrawAmount(Model model) {
        totalWithdrawAmount = 0.0;
        this.withdrawRepo.findAll().forEach((with) -> {
            totalWithdrawAmount += with.getAmount();
        });
        model.addAttribute("list", this.withdrawRepo.findAll());
        model.addAttribute("totalWithdrawAmount", totalWithdrawAmount);
        return "reports/withdrawamount";
    }

}
