package com.iesvdc.acceso.pistas_deportivas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ControReserva {

    @GetMapping("")
    public String getreservas() {
        return "reserva/reservas";
    }
    
    @GetMapping("/add")
    public String reservasAddForm() {
        return "reserva/reserva-add";
    }

    @PostMapping("/add")
    public String reservasAdd(@RequestBody String entity) {        
        return entity;
    }
    
    
    @GetMapping("/{id}/edit")
    public String reservaEditForm() {
        return "reserva/reserva-edit";
    }

    @PostMapping("/{id}/edit")
    public String reservasEdit(@RequestBody String entity) {        
        return entity;
    }
    
    @GetMapping("/{id}/del")
    public String reservasDelForm() {
        return "reserva/reserva-del";
    }

    @PostMapping("/{id}/del")
    public String reservasDel(@RequestBody String entity) {        
        return entity;
    }
}
