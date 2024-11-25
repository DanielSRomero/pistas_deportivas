package com.iesvdc.acceso.pistas_deportivas.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iesvdc.acceso.pistas_deportivas.modelos.Usuario;

public interface RepoUsuario extends JpaRepository <Usuario, Long>{
    
}
