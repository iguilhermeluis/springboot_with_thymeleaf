package br.com.guilherme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.guilherme.dominio.Chave;
import br.com.guilherme.service.ChaveService;

@Controller
@RequestMapping("/chave")
public class ChaveController {
	
	@Autowired
	private ChaveService chaveService;
	
	@GetMapping("/listar")
	public ModelAndView listaChaves() {
		ModelAndView mv = new ModelAndView("/chave/listaChaves");
		mv.addObject("chaves", chaveService.listaChaves());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Chave chave) {
		ModelAndView mv = new ModelAndView("/chave/addChaves");
		mv.addObject(chave);
		return mv;	
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Chave chave) {
		chaveService.inserir(chave);
		return listaChaves();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		chaveService.excluir(id);
		return listaChaves();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/chave/alteraChaves");
		mv.addObject("chave", chaveService.busca(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Chave chave) {
		chaveService.alterar(chave);
		return listaChaves();
	}
	
}
