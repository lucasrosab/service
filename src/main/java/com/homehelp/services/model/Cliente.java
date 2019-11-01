package com.homehelp.services.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(length = 100)
	private String sobrenome;

	@Column(length = 15, nullable = false)
	private String cpf;

	@Column(length = 10)
	private String sexo;

	@Column(length = 20, nullable = false)
	private String telefone;

	@Column(length = 250, nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String senha;
	
	@Column(length = 25, nullable = false)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(length = 10, nullable = false)
	private Calendar dataNascimento;
	
	@OneToMany(mappedBy = "cliente")
	private List<Solicitacao> solicitacao;
	
	@OneToMany(mappedBy = "cliente")
	private List<Favorito> favorito;

	private boolean ativo = true;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String sobrenome, String cpf, String sexo, String telefone, String email, String senha, String usuario, Calendar dataNascimento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.usuario = usuario;
		this.dataNascimento = dataNascimento;
	}


	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Solicitacao> getSolicitacao() {
		return solicitacao;
	}
	
	public List<Favorito> getFavorito() {
		return favorito;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
