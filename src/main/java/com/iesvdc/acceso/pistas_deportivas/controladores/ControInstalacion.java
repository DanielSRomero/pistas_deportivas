package com.iesvdc.acceso.pistas_deportivas.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesvdc.acceso.pistas_deportivas.modelos.Instalacion;
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
        model.addAttribute("operacion", "ADD");
        model.addAttribute("instalacion", new Instalacion());
        return "instalacion/instalacion-add";
    }

    @PostMapping("/add")
    public String instalacionesAdd(@ModelAttribute("instalacion") Instalacion instalacion) { 
        repoInstalacion.save(instalacion);       
        return "redirect:/instalaciones";
    }
    
    
    @GetMapping("/edit/{id}")
    public String instalacionEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Instalacion> oInstalacion = repoInstalacion.findById(id);
        if (oInstalacion.isPresent()) {
            model.addAttribute("operacion", "EDIT");
            model.addAttribute("instalacion", oInstalacion.get());
            model.addAttribute("instalaciones", repoInstalacion.findAll());
            return "instalacion/instalacion-add";
        } else {
            model.addAttribute("mensaje", "La instalacion no existe");
            model.addAttribute("titulo", "Error editando instalacion.");
            return "/error";
        }
    }

    @PostMapping("/edit/{id}")
    public String editInstalacion(
        @ModelAttribute("instalacion") Instalacion instalacion)  {
        repoInstalacion.save(instalacion);
        return "redirect:/instalaciones";
    }
    
    @GetMapping("/del/{id}")
    public String instalacionesDelForm(@PathVariable("id") Long id, Model model) {
        Optional<Instalacion> oInstalacion = repoInstalacion.findById(id);
        if (oInstalacion.isPresent()) {
            model.addAttribute("operacion", "DEL");
            model.addAttribute("instalacion", oInstalacion.get());
            model.addAttribute("instalaciones", repoInstalacion.findAll());
            return "instalacion/instalacion-add";
        } else {
            model.addAttribute("mensaje", "La instalacion no existe");
            model.addAttribute("titulo", "Error borrando instalacion.");
            return "/error";
        }
    }

    @PostMapping("/del/{id}")
    public String instalacionesDel(Instalacion instalacion) {   
        repoInstalacion.delete(instalacion);     
        return "redirect:/instalaciones";
    }
    
}
