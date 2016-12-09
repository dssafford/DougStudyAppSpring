package com.doug.controllers;

import com.doug.commands.JournalCommand;
import com.doug.domain.JournalSql;
import com.doug.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class JournalController {

    private JournalService journalService;

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(value="/journal/paging",method=RequestMethod.GET)
    public String journalPaging(Pageable pageable, Model model, Sort sort) {

//        pageable.first();

        model.addAttribute("journals", journalService.listAllByPage(pageable, sort, "id"));

        return "/journal/journalsPaging";
    }

//    @RequestMapping(value = "/doSort", method = RequestMethod.PUT)
//    public String sortStuff(Pageable pageable, Model model, Sort sort) {
//
//
//        model.addAttribute("journals", journalService.listAllByPage(pageable, sort));
//
//
//
//        return "/journal/journalsPaging";
//
//    }






    @RequestMapping(value = "/journal/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("journals", journalService.listAllJournals());
        return "/journal/journals";
    }

    @RequestMapping("journal/{id}")
    public String showJournal(@PathVariable Integer id, Model model){
        model.addAttribute("journal", journalService.getJournalById(id));
        return "journal/journalshow";
    }

    @RequestMapping("journal/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("journal", journalService.getJournalById(id));
        model.addAttribute("journalCommand", new JournalCommand());

        return "/journal/journaledit";
    }

    @RequestMapping("journal/delete/{id}")
    public String delete(@PathVariable Integer id){

        journalService.deleteJournal(id);

        return "redirect:/journal/paging";
    }

    @RequestMapping(value = "/journal/new", method = RequestMethod.GET)
    public String newJournal(Model model){

        model.addAttribute("journal", new JournalSql());
        model.addAttribute("journalCommand", new JournalCommand());


        return "journal/journalformnew";
    }

    @RequestMapping(value = "/dojournal", method = RequestMethod.POST)
    public String doJournal(@Valid JournalCommand journalCommand, BindingResult bindingResult,
                            JournalSql journal){

        if (bindingResult.hasErrors()) {
            return "journal/journalformnew";
        }

        JournalSql journalSql = journalService.saveOrUpdateJournal(journal);

//        return "redirect:/journal/" + journalSql.getId();
        return "redirect:/journal/paging";

    }

}
