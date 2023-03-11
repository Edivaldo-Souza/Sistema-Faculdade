package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.SituacaoAluno;

public class ResultadoAlunoDTO {
	private UUID uuid;
	private UUID turma_id;
	private String matricula;
	private String disc_cod;
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
	public String getDisc_cod() {
		return disc_cod;
	}
	public void setDisc_cod(String disc_cod) {
		this.disc_cod = disc_cod;
	}
	public float getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
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
	public UUID getTurma_id() {
		return turma_id;
	}
	public void setTurma_id(UUID turma_id) {
		this.turma_id = turma_id;
	}
}
