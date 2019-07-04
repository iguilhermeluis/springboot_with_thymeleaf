package br.com.guilherme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.guilherme.dominio.Fabricante;
import br.com.guilherme.service.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping("/listar")
	public ModelAndView listaFabricantes() {
		ModelAndView mv = new ModelAndView("/fabricante/listaFabricantes");
		mv.addObject("fabricantes", fabricanteService.listaFabricantes());
		return mv;
	}

	@GetMapping("/adicionar")
	public ModelAndView add(Fabricante fabricante) {
		ModelAndView mv = new ModelAndView("/fabricante/addFabricantes");
		mv.addObject(fabricante);
		return mv;	
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Fabricante fabricante) {
		fabricanteService.inserir(fabricante);
		return listaFabricantes();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		fabricanteService.excluir(id);
		return listaFabricantes();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/fabricante/alteraFabricantes");
		mv.addObject("fabricante", fabricanteService.busca(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Fabricante fabricante) {
		fabricanteService.alterar(fabricante);
		return listaFabricantes();
	}
	
	
	
}
