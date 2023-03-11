package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.SituacaoAluno;

public class AtualizarResultadoAlunoDTO {
	private float frequencia;
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private SituacaoAluno status;
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
}
