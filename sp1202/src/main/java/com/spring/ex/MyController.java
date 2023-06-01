package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class MyController {

	@RequestMapping("")
	public String boarblank(Model model) {
		model.addAttribute("id", 10);
		model.addAttribute("name", "blankpage");
		return "board/boardmain";
	}
	
	@RequestMapping("/")
	public String boardmain(Model model) {
		model.addAttribute("id", 11);
		model.addAttribute("name", "myController");
		return "board/boardmain";
	}
	
	@RequestMapping("/info")
	public String info(Model model) {
		model.addAttribute("id", 20);
		model.addAttribute("name", "myController");
		return "board/info";
	}

}
