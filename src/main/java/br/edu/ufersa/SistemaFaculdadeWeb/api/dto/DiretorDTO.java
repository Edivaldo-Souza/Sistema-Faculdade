package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Autorizacao;

public class DiretorDTO {
	private String nome;
	private UUID uuid;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
