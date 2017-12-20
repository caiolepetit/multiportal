package br.com.lepetit.multiportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lepetit.multiportal.model.Projeto;
import br.com.lepetit.multiportal.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	public List<Projeto> findAll() {
		return projetoRepository.findAll();
	}
	
	public Projeto findById(Long id) {
		return projetoRepository.findOne(id);
	}
	
	public Projeto save(Projeto projeto) {
		return projetoRepository.saveAndFlush(projeto);
	}
	
	public void delete(Long id) {
		projetoRepository.delete(id);
	}
	
}
