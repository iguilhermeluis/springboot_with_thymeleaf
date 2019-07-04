package br.com.guilherme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.guilherme.dominio.Acessorio;
import br.com.guilherme.service.AcessorioService;

@Controller
@RequestMapping("/acessorio") /*Criando mapeamento para esse controller, evitar ficando colocando /acessorio toda hora */
public class AcessorioController {
	
	@Autowired /* Evita ficar instanciando */
	private AcessorioService acessorioService;
	
	@GetMapping("/listar") /* Metodo GET os paramentros sao passados por URL */
	public ModelAndView listaAcessorios() {
		ModelAndView mv = new ModelAndView("/acessorio/listaAcessorios");
		mv.addObject("acessorios", acessorioService.listaAcessorios());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Acessorio acessorio) {
		ModelAndView mv = new ModelAndView("/acessorio/addAcessorios");
		mv.addObject(acessorio);
		return mv;	
	}
	
	@PostMapping("/salvar") /* Metodo POST os paramentros sao passados no corpo da requisicao */
	public ModelAndView inserir(Acessorio acessorio) {
		acessorioService.inserir(acessorio);
		return listaAcessorios();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		acessorioService.excluir(id);
		return listaAcessorios();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/acessorio/alteraAcessorios");
		mv.addObject("acessorio", acessorioService.busca(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Acessorio acessorio) {
		acessorioService.alterar(acessorio);
		return listaAcessorios();
	}
	
}
