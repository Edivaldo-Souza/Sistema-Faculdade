package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

public class UsuarioDTO {
	private String nome;
	private int permissao;
	private UUID uuid;
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
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
