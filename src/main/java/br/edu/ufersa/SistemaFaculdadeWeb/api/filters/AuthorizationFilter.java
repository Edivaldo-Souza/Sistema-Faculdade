package br.edu.ufersa.SistemaFaculdadeWeb.api.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.AuthenticationService;

public class AuthorizationFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication auth = AuthenticationService.getAuthentication((HttpServletRequest)request);
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
		
	}

}
