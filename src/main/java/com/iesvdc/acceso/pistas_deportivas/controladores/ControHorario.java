package com.iesvdc.acceso.pistas_deportivas.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String getHorarioes(Model model, 
    @PageableDefault(size = 10, sort = "id") Pageable Pageable) {
        Page<Horario> page = repoHorario.findAll(Pageable);
        model.addAttribute("page", page);
        model.addAttribute("horarios", page.getContent());
        return "horario/horarios";
    }


    @GetMapping("/add")
    public String addHorario(Model model) {
        model.addAttribute("horario", new Horario());
        model.addAttribute("instalaciones", repoInstalacion.findAll());
        model.addAttribute("operacion", "ADD");
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
        Model model) {

        Optional<Horario> oHorario = repoHorario.findById(id);
        if (oHorario.isPresent()) {
            model.addAttribute("operacion", "EDIT");
            model.addAttribute("horario", oHorario.get());
            model.addAttribute("instalaciones", repoInstalacion.findAll());
            return "horario/horario-add";
        } else {
            model.addAttribute("mensaje", "El horario no existe");
            model.addAttribute("titulo", "Error editando horario.");
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
        Model model) {

        Optional<Horario> oHorario = repoHorario.findById(id);
        if (oHorario.isPresent()) {
            model.addAttribute("operacion", "DEL");
            model.addAttribute("instalaciones", repoInstalacion.findAll());
            model.addAttribute("horario", oHorario.get());
            return "horario/horario-add";
        } else {
            model.addAttribute("mensaje", "El horario no existe");
            model.addAttribute("titulo", "Error borrando horario.");
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
