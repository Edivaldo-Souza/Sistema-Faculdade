package br.edu.ufersa.SistemaFaculdadeWeb.domain.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_resultados")
public class ResultadoAluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private UUID uuid;
	private String matricula;
	private String disc_cod;
	private UUID turma_id;
	private float frequencia;
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private SituacaoAluno status;
	
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
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public SituacaoAluno getStatus() {
		return status;
	}
	public void setStatus(SituacaoAluno status) {
		this.status = status;
	}
	public float getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
