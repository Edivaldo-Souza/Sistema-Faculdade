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

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Professor;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.ProfessorService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AtualizarProfessorDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.CriarProfessorDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.ProfessorDTO;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
	@Autowired
	private ProfessorService service;
	@Autowired
	private ModelMapper mapper; 
	
	@GetMapping
	public List<ProfessorDTO> getAll(){
		List<ProfessorDTO> profs = new ArrayList<ProfessorDTO>();
		for(Professor p: service.getAll()) {
			profs.add(mapper.map(p, ProfessorDTO.class));
		}
		return profs;
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<ProfessorDTO> getAt(@PathVariable UUID uuid){
		Professor p = service.getAt(uuid);
		if(p != null) {
			ProfessorDTO dto = mapper.map(service.getAt(uuid), ProfessorDTO.class);
			return new ResponseEntity<>(dto, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<ProfessorDTO> adicionar(@Valid @RequestBody CriarProfessorDTO dto){
		Professor p = service.create(mapper.map(dto, Professor.class));
		if(p != null) {
			ProfessorDTO dto2 = mapper.map(p, ProfessorDTO.class);
			return new ResponseEntity<>(dto2, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<ProfessorDTO> atualizar(@Valid @RequestBody AtualizarProfessorDTO dto){
		Professor p = service.update(mapper.map(dto, Professor.class));
		if(p != null) {
			ProfessorDTO dto2 = mapper.map(p, ProfessorDTO.class);
			return new ResponseEntity<>(dto2, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PatchMapping
	public ResponseEntity<ProfessorDTO> atualizartudo(@Valid @RequestBody AtualizarProfessorDTO dto){
		Professor p = service.update(mapper.map(dto, Professor.class));
		if(p != null) {
			ProfessorDTO dto2 = mapper.map(p, ProfessorDTO.class);
			return new ResponseEntity<>(dto2, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{uuid}")
	public String delete(@PathVariable UUID uuid){
		if(service.delete(uuid)) {
			return "Registro desse professor foi de Americanas";
		}
		return "shiiiiii...";
	}
}