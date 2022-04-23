package br.com.kdev.listatelefonica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kdev.listatelefonica.config.security.TokenService;
import br.com.kdev.listatelefonica.dto.LoginDto;
import br.com.kdev.listatelefonica.dto.TokenDto;




@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	

	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthenticationManager authManager;
	
	public AutenticacaoController() {
	}

	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginDto form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			//TokenDto gerarToken = tokenService.gerarToken(authentication);
			//return ResponseEntity.ok(gerarToken);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
