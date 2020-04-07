package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.services.HealthShopUserDetailsService;
import com.example.demo.util.JwtUtil;

//Intercept once every request
@Component
public class JWTRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private HealthShopUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;
	
	
	//This method checks Header JWT
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String email = null;
		String jwt = null;
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			email = jwtUtil.extractUsername(jwt);
		}
	}

	
	
}
