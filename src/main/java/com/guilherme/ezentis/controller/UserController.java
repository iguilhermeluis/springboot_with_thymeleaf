package com.guilherme.ezentis.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.guilherme.ezentis.model.Profile;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.service.ProfileService;
import com.guilherme.ezentis.service.UserService;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/dashboard")
	public ModelAndView viewDashboard() {
		ModelAndView mv = new ModelAndView("dashboard/index");
		mv.addObject("users", userService.listUsers());
		return mv;
	}
	
	
	@GetMapping("/dashboard/users/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		userService.delete(id);
		return listaUsers();
	}
	
	//chamando a view com id
	@GetMapping("/dashboard/users/update/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("dashboard/users/update");
		mv.addObject("user", userService.searchUser(id));
		return mv;
	}
	
	// salvando o edit via post
	@PostMapping("/dashboard/users/update")
	public ModelAndView alterar(User user) throws ObjectNotFoundException {
		userService.update(user);
		System.out.println("user NOME: " + user.getName());
		return listaUsers();
	}
	
	@GetMapping("/dashboard/users/list")
	public ModelAndView listaUsers() {
		ModelAndView mv = new ModelAndView("dashboard/users/list");
		mv.addObject("users", userService.listUsers());
		return mv;
	}
	
	@GetMapping("/dashboard/users/add")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("dashboard/users/add");
		mv.addObject("user", new User());
		mv.addObject("profiles", profileService.listProfiles());
		
		return mv;
	}
	
	//retornando o html de cadastro
	@GetMapping("/login/signup")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("login/signup");
		mv.addObject("user", new User());
		//mv.addObject("categorias", categoriaService.listaCategorias());
		return mv;
	}
	
	//retornando o html de login com cadastro
	@GetMapping("/login/signin")
	public ModelAndView loginView() {
		ModelAndView mv = new ModelAndView("login/signin");
		mv.addObject("user", new User());
		mv.addObject("profiles", profileService.listProfiles());
		
		return mv;
	}
	
	// cadastro
	@PostMapping("login/action/signup")
	public ModelAndView signup(User user) throws ObjectNotFoundException {
		Profile profileBD = profileService.searchProfile(user.getIdTempProfile());
		user.setProfiles(Arrays.asList(profileBD));
		
		userService.signup(user);
		
		return viewDashboard();
	}
	

	
	// login
	@PostMapping("login/action/signin")
	public ModelAndView signin(User user) {

		
		try {
			User userLogin = userService.signin(user);
			System.out.println(userLogin.getName());
			if(userLogin.getEmail().equals(user.getEmail())) 
			{
				/*
				  ModelAndView mv = new ModelAndView("login/signin");
				  mv.addObject("user", userLogin);
				 * */
				return viewDashboard();
			}
			else 
			{
				return loginView();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return loginView();
		}
		

	}
	
	
	
}
