package com.doug.controllers;

import com.doug.commands.JournalCommand;
import com.doug.domain.Journal;
import com.doug.domain.SortProperties;
import com.doug.domain.TestSort;
import com.doug.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class JournalController {
    private Integer counter =0;

    private JournalService journalService;

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }



    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testPaging(@RequestParam(value="name", defaultValue="World") String name, Pageable pageable, Model model) {

        TestSort testSort = new TestSort();
        testSort.setResult("machine&machine.dir=asc");

        model.addAttribute("journals", journalService.listAllByPage(pageable));
        model.addAttribute(testSort);

        return "journal/journalsPagingWorking";
    }

    @RequestMapping(value = "/journal/paging")
    public String journalPaging(@RequestParam(value="sortDirection", defaultValue="null") String sortDirection,
                                @RequestParam(value="sortProperty", defaultValue="null") String sortProperty,
                                  @PageableDefault(size = 10, page = 0, sort = "machine",
                                          direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        Sort.Order sortOrder; // = pageable.getSort().iterator().next();
        //Sort.Direction mySortDirection = Sort.Direction();

        //SortProperties sortProperties = new SortProperties();
//        sortProperties.sortColumn = sortColumn;
//        sortProperties.sortDirection = sortDirection;
//
//        model.addAttribute("journals", journalService.listAllByPage(pageable, sortColumn, sortDirection));
//
//        model.addAttribute(sortProperties);


        if(sortProperty.equals("null")) {
            sortOrder = pageable.getSort().iterator().next();
        } else {
            if(sortDirection.equals("ASC")) {
                sortOrder = new Sort.Order(Sort.Direction.ASC, sortProperty);
            } else {
                sortOrder = new Sort.Order(Sort.Direction.DESC, sortProperty);
            }
        }

        Page<Journal> journals = journalService.listAllByPage(pageable);

        model.addAttribute("journals", journals);
        model.addAttribute("sortProperties", sortOrder); // keeping 'sortProperties' for now, too lazy to change html

        return "/journal/journalsPaging";
    }

//    @RequestMapping(value="/journal/paging",method=RequestMethod.GET)
//    public String journalPaging(@RequestParam(value="sortColumn", defaultValue="id") String sortColumn,
//                                @RequestParam(value="sortDirection", defaultValue="asc") String sortDirection,
//                                Pageable pageable, Model model) {
//
//        counter = counter +1;
//
//        SortProperties sortProperties = new SortProperties();
//        sortProperties.sortColumn = sortColumn;
//        sortProperties.sortDirection = sortDirection;
//
//        model.addAttribute("journals", journalService.listAllByPage(pageable, sortColumn, sortDirection));
//
//        model.addAttribute(sortProperties);
//
//        return "/journal/journalsPaging";
//    }

    @RequestMapping(value = "/doSort", method = RequestMethod.POST)
    public String sortStuff(Pageable pageable, Model model, @ModelAttribute SortProperties sortProperties) {

        //model.addAttribute("sortProperty", new SortProperty());


        //Sort.Order myorder = new Sort.Order(sortProperties.getSortDirection(), sortProperties.getsortColumn());

        if(sortProperties.getsortColumn()==null) {
            sortProperties.setsortColumn("machine");
        }
        if(sortProperties.getSortDirection()==null) {
            sortProperties.setSortDirection("DESC");
        }


        model.addAttribute("journals", journalService.listAllByPage(pageable, sortProperties.getsortColumn(),
                sortProperties.getSortDirection()));

        return "/journal/journalsPaging";

    }


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

        model.addAttribute("journal", new Journal());
        model.addAttribute("journalCommand", new JournalCommand());


        return "journal/journalformnew";
    }

    @RequestMapping(value = "/dojournal", method = RequestMethod.POST)
    public String doJournal(@Valid JournalCommand journalCommand, BindingResult bindingResult,
                            Journal journal){

        if (bindingResult.hasErrors()) {
            return "journal/journalformnew";
        }

        Journal Journal = journalService.saveOrUpdateJournal(journal);

//        return "redirect:/journal/" + Journal.getId();
        return "redirect:/journal/paging";

    }

}
