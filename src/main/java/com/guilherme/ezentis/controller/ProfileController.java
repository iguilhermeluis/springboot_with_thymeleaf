package com.guilherme.ezentis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guilherme.ezentis.model.Profile;
import com.guilherme.ezentis.service.ProfileService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/dashboard/profiles/action/save")
	public ModelAndView save(Profile profile) throws ObjectNotFoundException {
		profileService.save(profile);
		
		return listProfiles();
	}
	
	//retornando o html de login com cadastro
	@GetMapping("/dashboard/profiles/add")
	public ModelAndView loginView() {
		ModelAndView mv = new ModelAndView("dashboard/profiles/add");
		mv.addObject("profile", new Profile());
		return mv;
	}
	
	
	@PostMapping("/dashboard/profiles/update")
	public ModelAndView alterar(Profile profile) throws ObjectNotFoundException {
			profileService.update(profile);
			System.out.println("user NOME: " + profile.getName());
			return listProfiles();
		}
		
	@GetMapping("/dashboard/profiles/list")
	public ModelAndView listProfiles() {
		ModelAndView mv = new ModelAndView("dashboard/profiles/list");
		mv.addObject("profiles", profileService.listProfiles());
		return mv;
	}
	
	@GetMapping("/dashboard/profiles/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		profileService.delete(id);
		return listProfiles();
	}
	
	//chamando a view com id
	@GetMapping("/dashboard/profiles/update/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("dashboard/profiles/update");
		mv.addObject("profile", profileService.searchProfile(id));
		return mv;
	}
}
