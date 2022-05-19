package br.com.ribeiro.fernando.springoauth2resourceserverkeycloack.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ribeiro.fernando.springoauth2resourceserverkeycloack.ports.controllers.contants.ControllersURIs;

@RestController
@RequestMapping(ControllersURIs.HELLO)
public class HelloWorldController {

	@GetMapping
	public String acceptOnlyWithAuthentication() {
		return "OK";
	}
	
}
