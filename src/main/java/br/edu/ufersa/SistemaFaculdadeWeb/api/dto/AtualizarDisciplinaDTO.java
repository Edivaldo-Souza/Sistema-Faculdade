package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class AtualizarDisciplinaDTO {
	@NotBlank(message = "É preciso fornecer o código da disciplina.")
	private String codigo;
	@NotBlank(message = "É preciso fornecer o nome da disciplina.")
	private String nome;
	private UUID uuid;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
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