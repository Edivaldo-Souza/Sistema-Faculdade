package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

public class DisciplinaDTO {

	private UUID uuid;
	private String codigo;
	private String nome;
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
