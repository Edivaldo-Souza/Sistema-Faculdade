package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizarDiretorDTO {
	@NotBlank(message="O nome não deve estar vazio")
	private String nome;
	@Size(min=8,max=20,message="A senha deve ter entre 8 a 20 digitos")
	private String senha;
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
}
