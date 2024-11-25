package com.iesvdc.acceso.pistas_deportivas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ControReserva {

    @GetMapping("/reservas")
    public String getreservas() {
        return "reserva/reservas";
    }
    
    @GetMapping("/reservas/add")
    public String reservasAddForm() {
        return "reserva/reserva-add";
    }

    @PostMapping("/reservas/add")
    public String reservasAdd(@RequestBody String entity) {        
        return entity;
    }
    
    
    @GetMapping("/reservas/{id}/edit")
    public String reservaEditForm() {
        return "reserva/reserva-edit";
    }

    @PostMapping("/reservas/{id}/edit")
    public String reservasEdit(@RequestBody String entity) {        
        return entity;
    }
    
    @GetMapping("/reservas/{id}/del")
    public String reservasDelForm() {
        return "reserva/reserva-del";
    }

    @PostMapping("/reservas/{id}/del")
    public String reservasDel(@RequestBody String entity) {        
        return entity;
    }
}
