package com.example.demo2.controller;

import com.example.demo2.models.Paradigm;
import com.example.demo2.services.ParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParController {

    @Autowired
    ParService parService;

    @RequestMapping("/parlist")
    public String getAll(Model model) {
        model.addAttribute("paradigms", parService.getAllPars());
        return "paradigmslist";
    }

    @RequestMapping("/newparrequest")
    public String newPar(Model model){
        model.addAttribute("paradigm", new Paradigm());
        return "newpar";
    }

    @RequestMapping(value="/postpar", method = RequestMethod.POST)
    public String addPar(@ModelAttribute Paradigm paradigm){
        parService.editOrNewPar(paradigm);
        return "redirect:/parlist";
    }

    @RequestMapping("/editpar/{id}")
    public String editPar(@PathVariable Long id, Model model){
        model.addAttribute("paradigm",parService.getPar(id));
        return "newpar";

    }
    //OK
    @RequestMapping("/deletepar/{id}")
    public String deletePar(@PathVariable Long id){
        parService.deletePar(id);
        return "redirect:/parlist";
    }
    @RequestMapping("/paradigm/{id}")
    public String showPar(@PathVariable Long id, Model model){
        model.addAttribute("paradigm",parService.getPar(id));
        return "paradigm";
    }

}
