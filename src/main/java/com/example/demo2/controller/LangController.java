package com.example.demo2.controller;


import com.example.demo2.models.Language;
import com.example.demo2.services.LangService;
import com.example.demo2.services.ParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LangController {

    @Autowired
    LangService langService;

    @Autowired
    ParService parService;

    @RequestMapping("/index")
    public String main(){
        return "main";
    }

    //OK
    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("languages", langService.getAllLangs());
        return "langlist";
    }

    //OK
    @RequestMapping("/lang/{id}")
    public String getLang(@PathVariable Long id, Model model){
        model.addAttribute("language", langService.getLang(id));
        return "language";
    }

    @RequestMapping("/new")
    public String newLang(Model model){
        model.addAttribute("language", new Language());
        model.addAttribute("allparadigms",parService.getAllPars());
        return "newlang";
    }

    @RequestMapping(value="/postlang", method = RequestMethod.POST)
    public String addLang(@ModelAttribute Language language){
        langService.editOrNewLang(language);
        return "redirect:/list";
    }

    @RequestMapping("/edit/{id}")
    public String editLang(@PathVariable Long id, Model model){
        model.addAttribute("language",langService.getLang(id));
        model.addAttribute("allparadigms",parService.getAllPars());
        return "newlang";

    }
    //OK
    @RequestMapping("/delete/{id}")
    public String deleteLang(@PathVariable Long id){
        langService.deleteLang(id);
        return "redirect:/list";
    }


}
