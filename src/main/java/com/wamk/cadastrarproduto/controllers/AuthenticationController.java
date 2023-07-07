package com.wamk.cadastrarproduto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wamk.cadastrarproduto.entities.user.AuthenticationDTO;
import com.wamk.cadastrarproduto.entities.user.LoginResponseDTO;
import com.wamk.cadastrarproduto.entities.user.RegisterDTO;
import com.wamk.cadastrarproduto.entities.user.User;
import com.wamk.cadastrarproduto.infra.security.TokenService;
import com.wamk.cadastrarproduto.repositories.UserRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassowrd = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassowrd);
		
		var token = tokenService.generateToken((User)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.userRepository.findByLogin(data.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encrypetedPassowrd = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encrypetedPassowrd, data.role());
		
		this.userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
}
