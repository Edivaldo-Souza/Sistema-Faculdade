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

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Turma;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service.TurmaService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AtualizarTurmaDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.CriarTurmaDTO;

@RestController
@RequestMapping("api/turma")
public class TurmaController {
	@Autowired
	private TurmaService service;
	@Autowired
	private ModelMapper mapper; 
	
	@GetMapping
	public List<TurmaDTO> getAll(){
		List<TurmaDTO> Turmas = new ArrayList<TurmaDTO>();
		for(Turma a: service.getAll()) {
			Turmas.add(mapper.map(a, TurmaDTO.class));
		}
		return Turmas;
	}
	
	@GetMapping("/id")
	public ResponseEntity<TurmaDTO> getAt(@PathVariable UUID id){
		Turma Turma = service.getAt(id);
		TurmaDTO dto = mapper.map(Turma, TurmaDTO.class);
		if(dto!=null) {
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<TurmaDTO> post(@Valid @RequestBody CriarTurmaDTO dto){
		Turma Turma = service.create(mapper.map(dto, Turma.class));
		if(Turma!=null) {
			TurmaDTO dto2 = mapper.map(Turma, TurmaDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<TurmaDTO> put(@Valid @RequestBody AtualizarTurmaDTO dto){
		Turma Turma = service.update(mapper.map(dto, Turma.class));
		if(Turma!=null) {
			TurmaDTO dto2 = mapper.map(Turma, TurmaDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PatchMapping
	public ResponseEntity<TurmaDTO> patch(@Valid @RequestBody AtualizarTurmaDTO dto){
		Turma Turma = service.updatePatch(mapper.map(dto, Turma.class));
		if(Turma!=null) {
			TurmaDTO dto2 = mapper.map(Turma, TurmaDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/id")
	public String delete(UUID id){
		if(service.delete(id)) {
			return "Turma deletada";
		}
		else {
			return "Nao foi possivel deletar";
		}
	}
}
