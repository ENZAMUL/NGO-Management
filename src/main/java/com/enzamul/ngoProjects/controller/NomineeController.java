package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.entity.Nominee;
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
@RequestMapping(value = "/nominee/")
public class NomineeController {

    @Autowired
    private NomineeRepo repo;

    @GetMapping(value = "add")
    public String addNomineeView(Model model) {
        model.addAttribute("nominee", new Nominee());

        return "nominee/add";
    }


    @PostMapping(value = "add")
    public String addNominee(@Valid Nominee nominee, BindingResult result, Model model){
        if(result.hasErrors()){
            return addNomineeView(model);
        }else {
            if (nominee != null){
                Nominee nominee1 = this.repo.findByNomineeName(nominee.getNomineeName());
                if (nominee1 != null){
                    model.addAttribute("existMsg", "NomineeName is already exist");
                }else {
                    this.repo.save(nominee);
                    model.addAttribute("nominee", new Nominee());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addNomineeView(model);
    }


    @GetMapping(value = "/list")
    public String nomineeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "nominee/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editNomineeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("nominee", this.repo.getOne(id));
        return "ngo/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editNominee(@Valid Nominee nominee, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "nominee/edit";
        } else {
            if (nominee != null) {
                /*
                 this.nomineeName = nomineeName;
        this.nomineeAge = nomineeAge;
        this.nomineeBirthDate = nomineeBirthDate;
        this.nomineeGender = nomineeGender;
        this.nomineeAddress = nomineeAddress;
        this.nomineeMobile = nomineeMobile;
        this.nomineeNid = nomineeNid;
        this.nomineeRelation = nomineeRelation;
                 */
                Nominee nominee1 = this.repo.getOne(id);
               nominee1.setNomineeName(nominee.getNomineeName());
               nominee1.setNomineeAge(nominee.getNomineeAge());
               nominee1.setNomineeBirthDate(nominee.getNomineeBirthDate());
               nominee1.setNomineeGender(nominee.getNomineeGender());
               nominee1.setNomineeAddress(nominee.getNomineeAddress());
               nominee1.setNomineeMobile(nominee.getNomineeMobile());
               nominee1.setNomineeNid(nominee.getNomineeNid());
                nominee1.setNomineeRelation(nominee.getNomineeRelation());

                    this.repo.save(nominee1);
                    model.addAttribute("nominee", new Nominee());
                    model.addAttribute("successMsg", "Update Successfully");
                }
            }

        return "redirect:/nominee/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delNominee(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/nominee/list";

    }




}
