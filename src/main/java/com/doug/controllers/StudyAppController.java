package com.doug.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login")
public class StudyAppController {

	//private static final String reader = "doug";

	//private ReadingListRepository readingListRepository;

//	@Autowired
//	public StudyAppController() {
//		//this.readingListRepository = readingListRepository;
//	}

	@RequestMapping(method= RequestMethod.GET)
	public String readersBooks(Model model) {
		//List<Book> readingList = readingListRepository.findByReader(reader);
//		if (readingList != null) {
//			model.addAttribute("books", readingList);
//		}
		return "login";
	}

//	@RequestMapping(method=RequestMethod.POST)
//	public String addToReadingList(Book book) {
//		book.setReader(reader);
//		readingListRepository.save(book);
//		return "redirect:/login";
//	}



//	@RequestMapping(method=RequestMethod.POST)
//	public String addToReadingList(Book book) {
//		book.setReader(reader);
//		readingListRepository.save(book);
//		return "redirect:/readingList";
//	}

}
