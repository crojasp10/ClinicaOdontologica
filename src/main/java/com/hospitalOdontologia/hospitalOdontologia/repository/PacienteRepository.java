package com.hospitalOdontologia.hospitalOdontologia.repository;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

    List<Paciente> findAll();
    Paciente save (Paciente paciente);
    Paciente findById(int id);


    @Query(value = "SELECT * FROM Paciente WHERE Paciente.nombre = :name and Paciente.apellido = :apellido",
            nativeQuery = true)
    List <Paciente> findAllNames(@Param("name") String name, @Param("apellido")String apellido);




}
