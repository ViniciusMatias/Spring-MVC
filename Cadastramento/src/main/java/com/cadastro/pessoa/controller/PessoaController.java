package com.cadastro.pessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cadastro.pessoa.model.Pessoa;
import com.cadastro.pessoa.repository.PessoaRepository;


@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	

	
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject(new Pessoa());
		modelAndView.addObject("pessoas", pessoaRepository.findAll());
		return modelAndView;
		}
	
		@PostMapping
		public String criar(Pessoa pessoa) {
			pessoaRepository.save(pessoa);
			return "redirect:/pessoas";
		}
		
		
	
}
