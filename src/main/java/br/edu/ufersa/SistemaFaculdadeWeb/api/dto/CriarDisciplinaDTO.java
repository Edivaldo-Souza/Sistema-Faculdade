package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;

public class CriarDisciplinaDTO {
	@NotBlank(message="É preciso fornecer o codigo da disciplina.")
	private String codigo;
	@NotBlank(message="É preciso fornecer o nome da disciplina.")
	private String nome;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}