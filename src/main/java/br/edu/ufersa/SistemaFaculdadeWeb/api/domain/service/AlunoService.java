package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Aluno;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.AlunoRepository;

@Service
public class AlunoService implements ServiceInterface<Aluno>{
	@Autowired
	AlunoRepository repository;

	@Override
	public List<Aluno> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno getAt(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno create(Aluno obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno update(Aluno obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno updatePatch(Aluno obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}
}
