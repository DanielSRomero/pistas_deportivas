package com.iesvdc.acceso.pistas_deportivas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ControUsuario {
    @GetMapping("/usuarios")
    public String getusuarios() {
        return "usuario/usuarios";
    }
    
    @GetMapping("/usuarios/add")
    public String usuariosAddForm() {
        return "usuario/usuario-add";
    }

    @PostMapping("/usuarios/add")
    public String usuariosAdd(@RequestBody String entity) {        
        return entity;
    }
    
    
    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditForm() {
        return "usuario/usuario-edit";
    }

    @PostMapping("/usuarios/{id}/edit")
    public String usuariosEdit(@RequestBody String entity) {        
        return entity;
    }
    
    @GetMapping("/usuarios/{id}/del")
    public String usuariosDelForm() {
        return "usuario/usuario-del";
    }

    @PostMapping("/usuarios/{id}/del")
    public String usuariosDel(@RequestBody String entity) {        
        return entity;
    }
}
