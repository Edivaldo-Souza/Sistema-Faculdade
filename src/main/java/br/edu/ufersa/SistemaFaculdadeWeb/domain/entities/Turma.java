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
@Table(name="tb_turmas")
public class Turma {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID uuid;
	private String local;
	private String horario;
	private boolean status;
	private String disc_cod;
	private String prof_cpf;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDisc_cod() {
		return disc_cod;
	}
	public void setDisc_cod(String disc_cod) {
		this.disc_cod = disc_cod;
	}
	public String getProf_cpf() {
		return prof_cpf;
	}
	public void setProf_cpf(String prof_cpf) {
		this.prof_cpf = prof_cpf;
	}


	
}
