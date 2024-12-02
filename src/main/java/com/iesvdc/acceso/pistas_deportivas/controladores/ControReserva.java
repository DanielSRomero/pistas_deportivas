package com.iesvdc.acceso.pistas_deportivas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesvdc.acceso.pistas_deportivas.modelos.Reserva;
import com.iesvdc.acceso.pistas_deportivas.repos.RepoReserva;

@Controller
@RequestMapping("/reservas")
public class ControReserva {

    @Autowired
    RepoReserva repoReserva;

    @GetMapping("")
    public String getreservas(Model model) {
        List<Reserva> reservas = repoReserva.findAll();
        model.addAttribute("reservas", reservas);
        return "reserva/reservas";
    }
    
    @GetMapping("/add")
    public String reservasAddForm(Model model) {
        model.addAttribute("reservas", new Reserva());
        return "reserva/reserva-add";
    }

    @PostMapping("/save")
    public String reservasAdd(@ModelAttribute("reserva") Reserva reserva) {        
        repoReserva.save(reserva);       
        return "redirect:/reservas";
    }
    
       
    @GetMapping("/edit/{id}")
    public String reservaEditForm(@PathVariable("id") Long id, Model model) {
        Reserva reserva = repoReserva.findById(id).get();
        model.addAttribute("reserva", reserva);
        return "reserva/reserva-edit";
    }

    @GetMapping("/del/{id}")
    public String reservasDelForm(@PathVariable("id") Long id, Model model) {
        Reserva reserva = repoReserva.findById(id).get();
        model.addAttribute("reserva", reserva);
        return "reserva/reserva-del";
    }

    @PostMapping("/del")
    public String reservasDel(@ModelAttribute("reserva") Reserva reserva) {   
        repoReserva.deleteById(reserva.getId());     
        return "redirect:/reservas";
    }
}
