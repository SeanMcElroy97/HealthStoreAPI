package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.HealthShopUserDetails;
import com.example.demo.model.authentication.AuthenticationRequest;
import com.example.demo.model.authentication.AuthenticationResponse;
import com.example.demo.repositories.CustomerRepo;
import com.example.demo.services.CustomerService;
import com.example.demo.services.HealthShopUserDetailsService;
import com.example.demo.util.JwtUtil;

@RestController("/")
@CrossOrigin(origins = "*")
public class HomeController {
	
	@Autowired
	CustomerService mCustomerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	HealthShopUserDetailsService healthShopUserDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	///APIs
	
	@GetMapping
	public String homeTest() {
		return "Home controller reached";
	}
	
	@GetMapping("/dos")
	public String testTwo() {
		return "reached dos";
	}
	
	///////
	
	@PostMapping("/newcust")
	public ResponseEntity<?> testcreateNewCustomer(@RequestBody Customer cust) throws Exception {
		//Customer cust = new Customer("jj@email", "password", "21 whitehouse avenue", "12345678");
		if(mCustomerService.createNewCustomerEntity(cust)==true) {
			return createAuthenticationToken(new AuthenticationRequest(cust.getEmail(), cust.getPassword()));
		}else {
			throw new Exception("User already exists with that email");
		}
		
	
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
				);
		} catch (BadCredentialsException e){
			throw new Exception("Incorrect email or password", e);
		}
		
		final UserDetails userDetails = healthShopUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getAuthorities().toString()));
		
		
	}
	
//	@PostMapping("/authenticate")
//	public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//		return authenticationRequest.getEmail() + " " + authenticationRequest.getPassword();
//		
//		
//	}

}
