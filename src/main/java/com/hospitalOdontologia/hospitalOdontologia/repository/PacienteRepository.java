package com.hospitalOdontologia.hospitalOdontologia.repository;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findAll();
    Paciente save (Paciente paciente);
    Paciente findById(int id);







}
