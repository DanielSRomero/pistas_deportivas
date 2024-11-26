package com.iesvdc.acceso.pistas_deportivas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class ControUsuario {
    @GetMapping("")
    public String getusuarios() {
        return "usuario/usuarios";
    }
    
    @GetMapping("/add")
    public String usuariosAddForm() {
        return "usuario/usuario-add";
    }

    @PostMapping("/add")
    public String usuariosAdd(@RequestBody String entity) {        
        return entity;
    }
    
    
    @GetMapping("/{id}/edit")
    public String usuarioEditForm() {
        return "usuario/usuario-edit";
    }

    @PostMapping("/{id}/edit")
    public String usuariosEdit(@RequestBody String entity) {        
        return entity;
    }
    
    @GetMapping("/{id}/del")
    public String usuariosDelForm() {
        return "usuario/usuario-del";
    }

    @PostMapping("/{id}/del")
    public String usuariosDel(@RequestBody String entity) {        
        return entity;
    }
}
