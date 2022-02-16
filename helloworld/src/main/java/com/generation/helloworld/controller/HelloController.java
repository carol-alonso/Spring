package com.generation.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class HelloController {
	
	@GetMapping
	public String getHello () {
		return "Minha primeira aplicação Hello World ";
	}
	
	@GetMapping("/turma44")
	public String getHello2 () {
		return "Minha turma durante os 3 meses de aprendizado.";
	}
	
	@GetMapping("/habilidades")
	public String getHello3 () {
		return "Usamos as habilidades de atenção aos detalhes e proatividade";
	}
	
	@GetMapping("/objetivos")
	public String getHello4 () {
		return "</br>Meus objetivos de aprendizagem atuais são:</br>"
				+ " </br> Melhorar minhas habilidades em OOP </br>"
				+ " </br> Melhorar minhas softskills em trabalho em equipe";
	}



}
