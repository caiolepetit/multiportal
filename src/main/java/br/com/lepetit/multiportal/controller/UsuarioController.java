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

import br.com.lepetit.multiportal.model.Usuario;
import br.com.lepetit.multiportal.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("/usuarios/home");
		modelAndView.addObject("usuarios", usuarioService.findAll());

		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView add(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/usuarios/add");
		modelAndView.addObject("usuario", usuario);

		return modelAndView;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(usuarioService.findById(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		usuarioService.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return add(usuario);
		}

		usuarioService.save(usuario);

		return new ModelAndView("redirect:/usuarios/");
	}
}
