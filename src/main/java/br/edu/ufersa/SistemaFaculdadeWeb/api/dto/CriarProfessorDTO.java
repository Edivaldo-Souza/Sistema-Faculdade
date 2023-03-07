package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CriarProfessorDTO {
	@NotBlank(message="Deve-se informar o CPF.")
	private String cpf;
	private String nome;
	@NotBlank(message="Não pode deixar esse campo vazio oh Zé '-'.")
	@Size(min=8, max=20,message="Seguinte parceiro. Senha entre 8 e 20 caracteres.")
	private String senha;
	@NotBlank(message="Deve-se informar o Endereço.")
	private String endereco;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}