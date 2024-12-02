package com.iesvdc.acceso.pistas_deportivas.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesvdc.acceso.pistas_deportivas.modelos.Horario;
import com.iesvdc.acceso.pistas_deportivas.repos.RepoHorario;
import com.iesvdc.acceso.pistas_deportivas.repos.RepoInstalacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/horarios")
public class ControHorario {
    
    @Autowired 
    RepoHorario repoHorario;
    @Autowired 
    RepoInstalacion repoInstalacion;

    @GetMapping("")
    public String getHorarioes(Model model) {
        List<Horario> horarios = repoHorario.findAll();
        model.addAttribute("horarios", horarios);
        return "horario/horarios";
    }


    @GetMapping("/add")
    public String addHorario(Model modelo) {
        modelo.addAttribute("operacion", "ADD");
        modelo.addAttribute("horario", new Horario());
        modelo.addAttribute("instalaciones", repoInstalacion.findAll());
        return "horario/horario-add";
    }

    @PostMapping("/add")
    public String addHorario(
        @ModelAttribute("horario") Horario horario)  {
        repoHorario.save(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/edit/{id}")
    public String editHorario( 
        @PathVariable @NonNull Long id,
        Model modelo) {

        Optional<Horario> oHorario = repoHorario.findById(id);
        if (oHorario.isPresent()) {
            modelo.addAttribute("operacion", "EDIT");
            modelo.addAttribute("horario", oHorario.get());
            modelo.addAttribute("instalaciones", repoInstalacion.findAll());
            return "horario/horario-add";
        } else {
            modelo.addAttribute("mensaje", "El horario no exsiste");
            modelo.addAttribute("titulo", "Error editando horario.");
            return "/error";
        }
    }

    @PostMapping("/edit/{id}")
    public String editHorario(
        @ModelAttribute("horario") Horario horario)  {
        repoHorario.save(horario);
        return "redirect:/horarios";
    }


    @GetMapping("/del/{id}")
    public String delHorario( 
        @PathVariable @NonNull Long id,
        Model modelo) {

        Optional<Horario> oHorario = repoHorario.findById(id);
        if (oHorario.isPresent()) {
            modelo.addAttribute("operacion", "DEL");
            modelo.addAttribute("horario", oHorario.get());
            return "horario/horario-add";
        } else {
            modelo.addAttribute("mensaje", "El horario no exsiste");
            modelo.addAttribute("titulo", "Error borrando horario.");
            return "/error";
        }
    }

    @PostMapping("/del/{id}")
    public String delHorario(
        @ModelAttribute("horario") Horario horario)  {
        repoHorario.delete(horario);
        return "redirect:/horarios";
    }
    
}
