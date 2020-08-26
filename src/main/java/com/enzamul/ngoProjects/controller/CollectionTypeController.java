package com.enzamul.ngoProjects.controller;


import com.enzamul.ngoProjects.entity.CollectionType;
import com.enzamul.ngoProjects.repo.CollectionTypeRepo;
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
@RequestMapping(value = "/collType/")
public class CollectionTypeController {

    @Autowired
    private CollectionTypeRepo repo;

    @GetMapping(value = "add")
    public String addCollectionTypeView(Model model) {
        model.addAttribute("collectionType", new CollectionType());
        return "collType/add";

    }

    @PostMapping(value = "add")
    public String addCollectionType(@Valid CollectionType collectionType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return addCollectionTypeView(model);
        } else {
            if (collectionType != null) {
                CollectionType collectionType1 = this.repo.findByTypeName(collectionType.getTypeName());
                if (collectionType1 != null) {
                    model.addAttribute("existMsg", "CollectionTypeName is already exist");
                } else {
                    this.repo.save(collectionType);
                    model.addAttribute("collectionType", new CollectionType());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return addCollectionTypeView(model);
    }

    @GetMapping(value = "/list")
    public String CollectionTypeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "collType/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editCollectionTypeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("collectionType", this.repo.getOne(id));
        return "collType/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editCollectionType(@Valid CollectionType collectionType, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "collType/edit";
        } else {
            if (collectionType != null) {
                CollectionType collectionType1 = this.repo.getOne(id);
                collectionType1.setTypeName(collectionType.getTypeName());

                    this.repo.save(collectionType1);
                    model.addAttribute("collectionType", new CollectionType());
                    model.addAttribute("successMsg", "Update Successfully");
                }
            }

        return "redirect:/collType/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delCollectionType(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/collType/list";

    }
}
