package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.model.HealthShopUserDetails;
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
		
		//Get User Details
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			email = jwtUtil.extractUsername(jwt);
		}
		
		
		//Validate USer details 
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			HealthShopUserDetails userDetails = (HealthShopUserDetails) this.userDetailsService.loadUserByUsername(email);
		
			//Validate JWT token
			if (jwtUtil.validateToken(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
		}
		
		//This filter passes to nect filter once finished
		filterChain.doFilter(request, response);
	}

	
	
}
