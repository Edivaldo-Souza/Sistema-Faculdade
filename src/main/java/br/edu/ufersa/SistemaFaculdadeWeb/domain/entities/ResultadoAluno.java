package br.edu.ufersa.SistemaFaculdadeWeb.domain.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="tb_resultados")
public class ResultadoAluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID uuid;
	@Column(updatable=false, nullable=false)
	private String matricula;
	private String discCod;
	@Column(updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID turma;
	private float frequencia;
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private SituacaoAluno status;
	
	
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
