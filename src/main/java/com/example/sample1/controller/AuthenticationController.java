package com.example.sample1.controller;


import com.example.sample1.constants.AnPhatConstants;
import com.example.sample1.model.User;
import com.example.sample1.model.request.LoginUser;
import com.example.sample1.model.response.AuthToken;
import com.example.sample1.service.impl.JwtUserDetailsService;
import com.example.sample1.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(AnPhatConstants.BASE_URL_ADMIN)
public class AuthenticationController {

	 @Autowired
	 private AuthenticationManager authenticationManager;

	 @Autowired
	 private JwtTokenUtil jwtTokenUtil;

	 @Autowired
	 private JwtUserDetailsService userDetailsService;

	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUser authenticationRequest) throws Exception {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthToken(token));
	 }

	 @RequestMapping(value = "/create", method = RequestMethod.POST)
	 public ResponseEntity<?> saveUser(@RequestBody User user) {
			return ResponseEntity.ok(userDetailsService.save(user));
	 }

	 private void authenticate(String username, String password) throws Exception {
			try {
				 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			} catch (DisabledException e) {
				 throw new Exception("USER_DISABLED", e);
			} catch (BadCredentialsException e) {
				 throw new Exception("INVALID_CREDENTIALS", e);
			}
	 }
}

