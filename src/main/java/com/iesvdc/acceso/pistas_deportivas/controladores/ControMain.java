package com.iesvdc.acceso.pistas_deportivas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ControMain {
    
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    
    @GetMapping("/error")
    public String getError() {
        return "error";
    }
    
}
