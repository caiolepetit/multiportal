package br.com.lepetit.multiportal.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30)
	@NotBlank(message = "Nome é uma informação obrigatória")
	private String nome;

	@Column(nullable = false, length = 15)
	@NotBlank(message = "Status é uma informação obrigatória")
	private String status;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data inicial é uma informação obrigatória")
	private Calendar data_inicial;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data final é uma informação obrigatória")
	private Calendar data_final;

	@Column(nullable = false, length = 10)
	@NotBlank(message = "Duração em horas é uma informação obrigatória")
	private String duracao_horas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Calendar data_inicial) {
		this.data_inicial = data_inicial;
	}

	public Calendar getData_final() {
		return data_final;
	}

	public void setData_final(Calendar data_final) {
		this.data_final = data_final;
	}

	public String getDuracao_horas() {
		return duracao_horas;
	}

	public void setDuracao_horas(String duracao_horas) {
		this.duracao_horas = duracao_horas;
	}

}
