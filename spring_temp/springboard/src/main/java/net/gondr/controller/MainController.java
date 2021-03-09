package net.gondr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainPage() {
		return "main";
	}
	// /test?age=gondr
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String sample(@RequestParam(value="age", required=false, defaultValue="10") int name) {
		return "main";
	}
	
}
