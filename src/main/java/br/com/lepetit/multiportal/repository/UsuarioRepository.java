package br.com.lepetit.multiportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lepetit.multiportal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);

}
