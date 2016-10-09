package com.doug.controllers;

import com.doug.domain.JournalSql;
import com.doug.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JournalController {

    private JournalService journalService;

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(value = "/journals", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("journals", journalService.listAllJournals());
        System.out.println("Returning dide rpoducts:");
        return "journals";
    }

    @RequestMapping("journal/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("journal", journalService.getJournalById(id));
        return "journalshow";
    }

    @RequestMapping("journal/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("journal", journalService.getJournalById(id));
        return "journalform";
    }

    @RequestMapping("journal/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        model.addAttribute("journal", journalService.getJournalById(id));

        return "journalform";
    }

    @RequestMapping("journal/new")
    public String newJournal(Model model){
        model.addAttribute("journal", new JournalSql());
        return "journalform";
    }

    @RequestMapping(value = "journal", method = RequestMethod.POST)
    public String saveProduct(JournalSql journal){

        journalService.saveJournal(journal);

        return "redirect:/journal/" + journal.getId();
    }

}
