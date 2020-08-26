package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.Loan;
import com.enzamul.ngoProjects.repo.AccountRepo;
import com.enzamul.ngoProjects.repo.BranchRepo;
import com.enzamul.ngoProjects.repo.EmployeeRepo;
import com.enzamul.ngoProjects.repo.LoanRepo;
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
@RequestMapping(value = "/loan/")
public class LoanController {

    @Autowired
    private LoanRepo loanRepo;


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BranchRepo branchRepo;


    @GetMapping(value = "add")
    public String addLoanView(Model model) {
        model.addAttribute("loan", new Loan());

        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        return "loan/add";
    }


    @PostMapping(value = "add")
    public String addLoan(@Valid Loan loan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addLoanView(model);
        } else {
            if (loan != null) {
                Loan loan1 = this.loanRepo.findByLoanCodeNumber(loan.getLoanCodeNumber());
                if (loan1 != null) {
                    model.addAttribute("existMsg", "LoanCodeNumber is already exist");
                } else {
                    this.loanRepo.save(loan);
                    model.addAttribute("loan", new Loan());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addLoanView(model);
    }


    @GetMapping(value = "/list")
    public String LoanList(Model model) {
        model.addAttribute("list", this.loanRepo.findAll());
        return "loan/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editLoanView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("loan", this.loanRepo.getOne(id));
        return "loan/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editLoan(@Valid Loan loan, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "loan/edit";
        } else {
            if (loan != null) {
                /*
                  this.loanCodeNumber = loanCodeNumber;
        this.loanDate = loanDate;
        this.loanAmount = loanAmount;
        this.noOfKisti = noOfKisti;
        this.loanPayableKisti = loanPayableKisti;
        this.employee = employee;
        this.account = account;
        this.branch = branch;
                 */
                Loan loan1 = this.loanRepo.getOne(id);
                loan1.setLoanCodeNumber(loan.getLoanCodeNumber());
                loan1.setLoanDate(loan.getLoanDate());
                loan1.setLoanAmount(loan.getLoanAmount());
                loan1.setNoOfKisti(loan.getNoOfKisti());
                loan1.setLoanPayableKisti(loan.getLoanPayableKisti());
                loan1.setEmployee(loan.getEmployee());
                loan1.setAccount(loan.getAccount());
                loan1.setBranch(loan.getBranch());

                this.loanRepo.save(loan);
                model.addAttribute("loan", new Loan());
                model.addAttribute("successMsg", "Update Successfully");
            }
        }

        return "redirect:/loan/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delLoan(@PathVariable("id") Long id) {
        this.loanRepo.deleteById(id);
        return "redirect:/loan/list";

    }


}