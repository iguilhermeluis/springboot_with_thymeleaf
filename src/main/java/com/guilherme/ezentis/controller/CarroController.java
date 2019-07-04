package com.guilherme.ezentis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guilherme.ezentis.model.Carro;
import com.guilherme.ezentis.service.AcessorioService;
import com.guilherme.ezentis.service.CarroService;
import com.guilherme.ezentis.service.ChaveService;
import com.guilherme.ezentis.service.FabricanteService;

@Controller
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private ChaveService chaveService;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@Autowired
	private AcessorioService acessorioService;
	
	@GetMapping("/carro")
	public ModelAndView carroView() {
		ModelAndView mv = new ModelAndView("concessionaria/carro");
		mv.addObject("carro", new Carro());
		mv.addObject("chaves", chaveService.list());
		mv.addObject("fabricantes", fabricanteService.list());
		mv.addObject("acessorios", acessorioService.listar());
		return mv;
	}
	
	@GetMapping("/carro/list")
	public ModelAndView listCarro() {
		ModelAndView mv = new ModelAndView("concessionaria/list-carro");
		mv.addObject("carros", carroService.listaCarros());
		return mv;
	}

	@PostMapping("/carro")
	public ModelAndView salvar(Carro carro) {
		carroService.cadastrar(carro);
		return listCarro();
	}
	
	@PostMapping("/carrro/edit")
	public ModelAndView edit(Carro carro) {
		carroService.alterar(carro);
		return listCarro();
	}
	
	@GetMapping("/")
	public ModelAndView viewInit() {
		return carroView();
	}
	
}
