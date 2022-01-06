package com.trabalhoFinal.bookCatalog.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/HelloWorld")
	public ModelAndView firstPage() {
		return new ModelAndView("helloworld");
	}

}