package com.iesvdc.acceso.pistas_deportivas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesvdc.acceso.pistas_deportivas.modelos.Instalacion;
import com.iesvdc.acceso.pistas_deportivas.modelos.Usuario;
import com.iesvdc.acceso.pistas_deportivas.repos.RepoInstalacion;


@Controller
@RequestMapping("/instalaciones")
public class ControInstalacion {

    @Autowired
    RepoInstalacion repoInstalacion;
    
    @GetMapping("")
    public String getInstalaciones(Model model) {
        List<Instalacion> instalaciones = repoInstalacion.findAll();
        model.addAttribute("instalaciones", instalaciones);
        return "instalacion/instalaciones";
    }
    
    @GetMapping("/add")
    public String instalacionesAddForm(Model model) {
        model.addAttribute("instalacion", new Instalacion());
        return "instalacion/instalacion-add";
    }

    @PostMapping("/save")
    public String instalacionesAdd(@ModelAttribute("instalacion") Instalacion instalacion) { 
        repoInstalacion.save(instalacion);       
        return "redirect:/instalaciones";
    }
    
    
    @GetMapping("/{id}/edit")
    public String instalacionEditForm(@PathVariable("id") Long id, Model model) {
        Instalacion instalacion = repoInstalacion.findById(id).get();
        model.addAttribute(instalacion);
        return "instalacion/instalacion-edit";
    }

    
    @GetMapping("/{id}/del")
    public String instalacionesDelForm() {
        return "instalacion/instalacion-del";
    }

    @PostMapping("/{id}/del")
    public String instalacionesDel(@RequestBody String entity) {        
        return entity;
    }
    
}
