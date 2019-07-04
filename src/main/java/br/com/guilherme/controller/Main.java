package br.com.guilherme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
	
	@GetMapping("/")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("/index.html");/* REFERENCIA DO HTML */
		return mv; 
	}
	
}
