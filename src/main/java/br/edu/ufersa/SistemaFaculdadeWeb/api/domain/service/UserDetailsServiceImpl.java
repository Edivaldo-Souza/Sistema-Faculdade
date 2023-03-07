package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Usuario;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuarioAtual = usuarioRep.findByNome(username);
		UserDetails usuario = new org.springframework.security.core.userdetails.
				User(username, usuarioAtual.getSenha(), true,true,true,true,
						AuthorityUtils.createAuthorityList("USER"));
		return usuario;
	}

}
