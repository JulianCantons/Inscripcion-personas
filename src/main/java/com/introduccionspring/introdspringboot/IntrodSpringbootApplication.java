package com.introduccionspring.introdspringboot;

import com.introduccionspring.introdspringboot.entities.Persona;
import com.introduccionspring.introdspringboot.repository.PersonaRepository;
import com.introduccionspring.introdspringboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class IntrodSpringbootApplication {

	@Autowired
	private PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(IntrodSpringbootApplication.class, args);


	}
/*
	@Override
	public void run(String... args) throws Exception {
		personaService.crearPersona(new Persona(6L,"Julian2",30));
		personaService.crearPersona(new Persona(7L,"Roman2",46));
		personaService.crearPersona(new Persona(8L,"Lucia2",19));
		personaService.crearPersona(new Persona(9L,"Juliana2",30));

		System.out.println("Numero de personas guardadas " + personaService.contarPersonas()) ;

		List<Persona> personas = personaService.obtenerPersonas();
		personas.forEach(p -> System.out.println("Nombre de la persona " + p.getNombre()));
	*/

}

