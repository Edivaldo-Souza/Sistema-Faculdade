package br.edu.ufersa.SistemaFaculdadeWeb.api.RestControllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.UsuarioDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.UsuarioService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController{
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{nome}")
	public ResponseEntity<UsuarioDTO> getByNome(@PathVariable String nome){
		UsuarioDTO dto = mapper.map(service.getByNome(nome),UsuarioDTO.class);
		if(dto!=null) {
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
