package br.com.guilherme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.guilherme.dominio.Documento;
import br.com.guilherme.service.DocumentoService;

@Controller
@RequestMapping("/documento")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;
	
	@GetMapping("/listar")
	public ModelAndView listaDocumentos() {
		ModelAndView mv = new ModelAndView("/documento/listaDocumentos");
		mv.addObject("documentos", documentoService.listaDocumentos());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Documento documento) {
		ModelAndView mv = new ModelAndView("/documento/addDocumentos");
		mv.addObject(documento);
		return mv;	
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Documento documento) {
		documentoService.inserir(documento);
		return listaDocumentos();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		documentoService.excluir(id);
		return listaDocumentos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/documento/alteraDocumentos");
		mv.addObject("documento", documentoService.busca(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Documento documento) {
		documentoService.alterar(documento);
		return listaDocumentos();
	}
	
}
