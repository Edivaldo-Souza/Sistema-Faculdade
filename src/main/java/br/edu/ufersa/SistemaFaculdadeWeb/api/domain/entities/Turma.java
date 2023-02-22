package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_turmas")
public class Turma {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private UUID uuid;
	private String local;
	private String horario;
	private boolean status;
	private long discplina_id;
	
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
	public long getDiscplina_id() {
		return discplina_id;
	}
	public void setDiscplina_id(long discplina_id) {
		this.discplina_id = discplina_id;
	}

	
}
