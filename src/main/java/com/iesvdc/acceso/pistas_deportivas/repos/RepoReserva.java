package com.iesvdc.acceso.pistas_deportivas.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iesvdc.acceso.pistas_deportivas.modelos.Reserva;

public interface RepoReserva extends JpaRepository <Reserva, Long>{
    
}
