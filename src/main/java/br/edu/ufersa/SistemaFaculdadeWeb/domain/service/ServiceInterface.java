package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

public interface ServiceInterface<T>{
	public List<T> getAll();
	public T getAt(UUID id);
	public T create(T obj);
	public T update(T obj);
	public T updatePatch(T obj);
	public boolean delete(UUID id);
}
