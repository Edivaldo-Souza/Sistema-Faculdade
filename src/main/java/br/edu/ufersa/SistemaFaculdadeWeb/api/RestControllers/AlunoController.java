package br.edu.ufersa.SistemaFaculdadeWeb.api.RestControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Aluno;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.AlunoService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AtualizarAlunoDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.CriarAlunoDTO;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {
	@Autowired
	private AlunoService service;
	@Autowired
	private ModelMapper mapper; 
	
	@GetMapping
	public List<AlunoDTO> getAll(){
		List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
		for(Aluno a: service.getAll()) {
			alunos.add(mapper.map(a, AlunoDTO.class));
		}
		return alunos;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAt(@PathVariable UUID id){
		AlunoDTO dto = mapper.map(service.getAt(id), AlunoDTO.class);
		if(dto!=null) {
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> post(@Valid @RequestBody CriarAlunoDTO dto){
		Aluno aluno = service.create(mapper.map(dto, Aluno.class));
		if(aluno!=null) {
			AlunoDTO dto2 = mapper.map(aluno, AlunoDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<AlunoDTO> put(@Valid @RequestBody AtualizarAlunoDTO dto){
		Aluno aluno = service.update(mapper.map(dto, Aluno.class));
		if(aluno!=null) {
			AlunoDTO dto2 = mapper.map(aluno, AlunoDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PatchMapping
	public ResponseEntity<AlunoDTO> patch(@Valid @RequestBody AtualizarAlunoDTO dto){
		Aluno aluno = service.updatePatch(mapper.map(dto, Aluno.class));
		if(aluno!=null) {
			AlunoDTO dto2 = mapper.map(aluno, AlunoDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id){
		if(service.delete(id)) {
			return "Aluno deletado";
		}
		else {
			return "Nao foi possivel deletar";
		}
	}
}
