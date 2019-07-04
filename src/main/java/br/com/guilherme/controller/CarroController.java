package br.com.guilherme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.guilherme.dominio.Carro;
import br.com.guilherme.service.AcessorioService;
import br.com.guilherme.service.CarroService;
import br.com.guilherme.service.ChaveService;
import br.com.guilherme.service.DocumentoService;
import br.com.guilherme.service.FabricanteService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private ChaveService chaveService;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@Autowired
	private AcessorioService acessorioService;
	
	@Autowired
	private DocumentoService documentoService;

	@Autowired
	private CarroService carroService;
	
	@GetMapping("/listar")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("/carro/listaCarros");/* REFERENCIA DO HTML */
		mv.addObject("carros", carroService.listaCarros()); /* passo um Array com todos os carros cadastrados, consigo fazer um for view */
		return mv; 
	}

	@GetMapping("/adicionar")
	public ModelAndView add(Carro carro) {
		ModelAndView mv = new ModelAndView("/carro/addCarros");
		mv.addObject(carro); /* crio um objeto vazio para eu conseguir trabalhar na view */
		mv.addObject("chaves", chaveService.listaChaves());
		mv.addObject("fabricantes", fabricanteService.listaFabricantes());
		mv.addObject("acessorios", acessorioService.listaAcessorios());
		mv.addObject("documentos", documentoService.listaDocumentos());
		return mv;	
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Carro carro) {
		carroService.save(carro);
		return listaCarros();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		carroService.excluir(id);
		return listaCarros();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) { /* o @PathVariable captura os parametros passado na URL no caso o ID */
		ModelAndView mv = new ModelAndView("/carro/alteraCarros");
		mv.addObject("carro", carroService.busca(id)); /* BUSCO O CARRO POR ID E PASSO PARA VIEW */
		mv.addObject("chaves", chaveService.listaChaves());
		mv.addObject("fabricantes", fabricanteService.listaFabricantes());
		mv.addObject("acessorios", acessorioService.listaAcessorios());
		mv.addObject("documentos", documentoService.listaDocumentos());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carro) {
		System.out.println(carro.toString());
		carroService.alterar(carro);
		return listaCarros(); /* APOS RETORNA EU CHAMO A VIEW DE LISTAR CARRO */
	}	
}
