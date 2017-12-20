package br.com.lepetit.multiportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lepetit.multiportal.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{ }
