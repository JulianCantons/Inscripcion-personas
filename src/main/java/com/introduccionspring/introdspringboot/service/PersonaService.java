package com.introduccionspring.introdspringboot.service;

import com.introduccionspring.introdspringboot.entities.Persona;

import java.util.List;

public interface PersonaService {

    List <Persona> obtenerPersonas();

    Persona obtenerPorId(Long id);

    Persona crearPersona(Persona persona);

    Persona actualizarPersona(Long id, Persona persona);

    void eliminarPersona(Long id);


    long contarPersonas();
}
