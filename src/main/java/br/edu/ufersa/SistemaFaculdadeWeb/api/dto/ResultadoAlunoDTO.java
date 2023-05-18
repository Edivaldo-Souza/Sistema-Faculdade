package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.SituacaoAluno;

public class ResultadoAlunoDTO {
	private UUID uuid;
	private UUID turma;
	private String matricula;
	private String discCod;
	private float frequencia;
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private SituacaoAluno status;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
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
	public float getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public SituacaoAluno getStatus() {
		return status;
	}
	public void setStatus(SituacaoAluno status) {
		this.status = status;
	}
	public UUID getTurma() {
		return turma;
	}
	public void setTurma(UUID turma) {
		this.turma = turma;
	}
	
}
