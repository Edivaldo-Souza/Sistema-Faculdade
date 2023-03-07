package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizarAlunoDTO {
	@NotBlank(message="O nome não deve estar vazio")
	private String nome;
	@NotBlank(message="O endereco não deve estar vazio")
	private String endereco;
	@Size(min=8,max=20,message="A senha deve ter entre 8 a 20 digitos")
	private String senha;
	private UUID uuid;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
