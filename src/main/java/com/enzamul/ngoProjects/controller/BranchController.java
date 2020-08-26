package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.Branch;
import com.enzamul.ngoProjects.repo.BranchRepo;
import com.enzamul.ngoProjects.repo.EmployeeRepo;
import com.enzamul.ngoProjects.repo.NgoRepo;
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
@RequestMapping(value = "/branch/")
public class BranchController {

    @Autowired
    private BranchRepo branchRepo;



    @Autowired
    private NgoRepo ngoRepo;




    @GetMapping(value = "add")
    public String addBranchView(Model model) {
        model.addAttribute("branch", new Branch());
        model.addAttribute("ngoList", this.ngoRepo.findAll());
        return "branch/add";
    }


  @PostMapping(value = "add")
  public String addBranch(@Valid Branch branch, BindingResult result, Model model){
      if(result.hasErrors()){
          return addBranchView(model);
      }else {
          if (branch != null){
              Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
              if (branch1 != null){

                  model.addAttribute("existMsg", "BranchName is already exist");
              }else {
//                  branch.setBranchName(branch.getBranchName()+branch.getBranchName());
                  this.branchRepo.save(branch);
                  model.addAttribute("branch", new Branch());
                  model.addAttribute("successMsg", "Data Insert is Success");
              }
          }
      }
      return addBranchView(model);
  }


    @GetMapping(value = "/list")
    public String BranchList(Model model) {
        model.addAttribute("list", this.branchRepo.findAll());
        return "branch/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editBranchView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("branch", this.branchRepo.getOne(id));
        return "user/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editBranch(@Valid Branch branch, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "branch/edit";
        } else {
            if (branch != null) {
                Branch branch1 = this.branchRepo.getOne(id);
                /*
                   this.branchName = branchName;
        this.branchCode = branchCode;
        this.branchAddress = branchAddress;
        this.ngo = ngo;
                 */
                branch1.setBranchName(branch.getBranchName());
                branch1.setBranchCode(branch.getBranchCode());
                branch1.setBranchAddress(branch.getBranchAddress());
                branch1.setNgo(branch.getNgo());

                    this.branchRepo.save(branch1);
                    model.addAttribute("branch", new Branch());
                    model.addAttribute("successMsg", "Update Successfull");
                }
            }

        return "redirect:/branch/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delBranch(@PathVariable("id") Long id) {
        this.branchRepo.deleteById(id);
        return "redirect:/branch/list";

    }


}