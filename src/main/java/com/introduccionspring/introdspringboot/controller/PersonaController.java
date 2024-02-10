package com.introduccionspring.introdspringboot.controller;


import com.introduccionspring.introdspringboot.entities.Persona;
import com.introduccionspring.introdspringboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaServicio;
    @GetMapping
    public String listarPersonas(Model model)
    {
        List<Persona> personas = personaServicio.obtenerPersonas();
        model.addAttribute("listaPersonas", personas);
        return "listado";
    }
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaPersona(Model modelo)
    {
        modelo.addAttribute("persona", new Persona());
        modelo.addAttribute("accion", "/personas");

        return "formulario";
    }

    @PostMapping("/nueva")
    public String guardarNuevaPersona(@ModelAttribute Persona persona) {
        personaServicio.crearPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model modelo)
    {
        modelo.addAttribute("persona", persona);
        modelo.addAttribute("accion", "/personas/editar/"+id);
        return "formulario";
    }
    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona)
    {
        personaServicio.actualizarPersona(id, persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id)
    {
        personaServicio.eliminarPersona(id);
        return "redirect:/personas";
    }
}
