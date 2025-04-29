package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")  // Habilitar CORS para todo el controlador
@RestController
public class GreetingController {

	private static final String template = "¡Hola, %s!";  // Mensaje en español
	private final AtomicLong contador = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting saludar(
			@RequestParam(value = "name", defaultValue = "Mundo") String nombre) {

		return new Greeting(contador.incrementAndGet(), String.format(template, nombre));
	}
}