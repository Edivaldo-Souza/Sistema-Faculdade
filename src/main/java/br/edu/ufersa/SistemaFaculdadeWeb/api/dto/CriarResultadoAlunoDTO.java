package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class CriarResultadoAlunoDTO {
	@NotBlank(message="numero da matricula necessario")
	private String matricula;
	@NotBlank(message="codigo da disciplina necessario")
	private String discCod;
	private UUID turma;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDiscCod() {
		return discCod;
	}
	public void setDiscCod(String discCod) {
		this.discCod = discCod;
	}
	public UUID getTurma() {
		return turma;
	}
	public void setTurma(UUID turma) {
		this.turma = turma;
	}
	
	
	
}
