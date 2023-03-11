package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class CriarResultadoAlunoDTO {
	@NotBlank(message="numero da matricula necessario")
	private String matricula;
	@NotBlank(message="codigo da disciplina necessario")
	private String disc_cod;
	private UUID turma_id;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDisc_cod() {
		return disc_cod;
	}
	public void setDisc_cod(String disc_cod) {
		this.disc_cod = disc_cod;
	}
	public UUID getTurma_id() {
		return turma_id;
	}
	public void setTurma_id(UUID turma_id) {
		this.turma_id = turma_id;
	}
	
}
