package br.com.lepetit.multiportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lepetit.multiportal.model.Projeto;
import br.com.lepetit.multiportal.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("/projetos/home");
		modelAndView.addObject("projetos", projetoService.findAll());

		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView add(Projeto projeto) {
		ModelAndView modelAndView = new ModelAndView("/projetos/add");
		modelAndView.addObject("projeto", projeto);

		return modelAndView;

	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(projetoService.findById(id));
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		projetoService.delete(id);
		
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Projeto projeto, BindingResult result) {
		if(result.hasErrors()) {
			return add(projeto);
		}
		
		projetoService.save(projeto);
		
		return new ModelAndView("redirect:/projetos/");
	}
}
