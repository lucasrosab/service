package com.homehelp.services.controller.form;

import com.homehelp.services.model.Pessoa;
import com.homehelp.services.repository.PessoaRepository;

public class PessoaForm {
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Pessoa converter(PessoaRepository pessoaRepository) {
		return new Pessoa(nome,sobrenome,cpf,sexo,telefone,email,senha);
	}

}
