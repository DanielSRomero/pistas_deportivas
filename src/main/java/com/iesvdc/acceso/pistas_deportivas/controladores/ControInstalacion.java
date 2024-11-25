package com.iesvdc.acceso.pistas_deportivas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ControInstalacion {
    
    @GetMapping("/instalaciones")
    public String getInstalaciones() {
        return "instalacion/instalaciones";
    }
    
    @GetMapping("/instalaciones/add")
    public String instalacionesAddForm() {
        return "instalacion/instalacion-add";
    }

    @PostMapping("/instalaciones/add")
    public String instalacionesAdd(@RequestBody String entity) {        
        return entity;
    }
    
    
    @GetMapping("/instalaciones/{id}/edit")
    public String instalacionEditForm() {
        return "instalacion/instalacion-edit";
    }

    @PostMapping("/instalaciones/{id}/edit")
    public String instalacionesEdit(@RequestBody String entity) {        
        return entity;
    }
    
    @GetMapping("/instalaciones/{id}/del")
    public String instalacionesDelForm() {
        return "instalacion/instalacion-del";
    }

    @PostMapping("/instalaciones/{id}/del")
    public String instalacionesDel(@RequestBody String entity) {        
        return entity;
    }
    
}
