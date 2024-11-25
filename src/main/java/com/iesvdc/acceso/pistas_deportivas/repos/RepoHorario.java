package com.iesvdc.acceso.pistas_deportivas.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iesvdc.acceso.pistas_deportivas.modelos.Horario;

public interface RepoHorario extends JpaRepository <Horario, Long>{
    
}
