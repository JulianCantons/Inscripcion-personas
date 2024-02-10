package com.introduccionspring.introdspringboot.service;

import com.introduccionspring.introdspringboot.entities.Persona;
import com.introduccionspring.introdspringboot.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
    Persona personaBBDD = personaRepository.findById(id).orElse(null);
    if (personaBBDD != null)
    {
        personaBBDD.setNombre(persona.getNombre());
        personaBBDD.setEdad(persona.getEdad());
        return personaRepository.save(personaBBDD);
    }
    return null;
    }

    @Override
    public void eliminarPersona(Long id) {
    personaRepository.deleteById(id);
    }

    @Override
    public long contarPersonas() {
        return personaRepository.count();
    }
}
