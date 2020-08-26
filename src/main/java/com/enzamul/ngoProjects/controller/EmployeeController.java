package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.repo.BranchRepo;
import com.enzamul.ngoProjects.repo.EmployeeRepo;
import com.enzamul.ngoProjects.repo.EmployeeTypeRepo;
import com.enzamul.ngoProjects.repo.UserRepo;
import com.enzamul.ngoProjects.repo.NgoRepo;
import com.enzamul.ngoProjects.entity.Employee;
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
@RequestMapping(value = "/employee/")
public class EmployeeController {

  @Autowired
  private EmployeeRepo employeeRepo;



    @Autowired
    private NgoRepo ngoRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private EmployeeTypeRepo employeeTypeRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "add")
    public String addEmployeeView(Model model) {
        model.addAttribute("employee", new Employee());
       model.addAttribute("employeeList", this.employeeRepo.findAll());

        model.addAttribute("ngoList", this.ngoRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("employeeTypeList", this.employeeTypeRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        return "employee/add";
    }


  @PostMapping(value = "add")
  public String addEmployee(@Valid Employee employee, BindingResult result, Model model){
      if(result.hasErrors()){
          return addEmployeeView(model);
      }else {
          if (employee != null){
              Employee employee1 = this.employeeRepo.findByEmployeeName(employee.getEmployeeName());
              if (employee1 != null){
                  model.addAttribute("existMsg", "EmployeeName is already exist");
              }else {
                  this.employeeRepo.save(employee);
                  model.addAttribute("employee", new Employee());
                  model.addAttribute("successMsg", "Data insert is Success");
              }
          }
      }
      return addEmployeeView(model);
  }


    @GetMapping(value = "/list")
    public String EmployeeList(Model model) {
        model.addAttribute("list", this.employeeRepo.findAll());
        return "employee/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editEmployeeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", this.employeeRepo.getOne(id));
        return "employee/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editEmployee(@Valid Employee employee, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "employee/edit";
        } else {
            if (employee != null) {
                /*
                  this.employeeName = employeeName;
        this.employeeCode = employeeCode;
        this.employeeGender = employeeGender;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.regiDate = regiDate;
        this.emplooyeeMobile = emplooyeeMobile;
        this.employeeddress = employeeddress;
        this.employeeNid = employeeNid;
        this.ngo = ngo;
        this.branch = branch;
        this.employeeType = employeeType;
        this.user = user;
                 */
                Employee employee1 = this.employeeRepo.getOne(id);
                employee1.setEmployeeName(employee.getEmployeeName());
                employee1.setEmployeeCode(employee.getEmployeeCode());
                employee1.setEmployeeGender(employee.getEmployeeGender());
                employee1.setEmployeeAge(employee.getEmployeeAge());
                employee1.setEmployeeSalary(employee.getEmployeeSalary());
                employee1.setRegiDate(employee.getRegiDate());
                employee1.setEmplooyeeMobile(employee.getEmplooyeeMobile());
                employee1.setEmployeeddress(employee.getEmployeeddress());
                employee1.setEmployeeNid(employee.getEmployeeNid());
                employee1.setNgo(employee.getNgo());
                employee1.setBranch(employee.getBranch());
                employee1.setEmployeeType(employee.getEmployeeType());
                employee1.setUser(employee.getUser());

                    this.employeeRepo.save(employee1);
                    model.addAttribute("employee", new Employee());
                    model.addAttribute("successMsg", "Update Successfully");
                }
            }

        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delEmployee(@PathVariable("id") Long id) {
        this.employeeRepo.deleteById(id);
        return "redirect:/employee/list";

    }


}