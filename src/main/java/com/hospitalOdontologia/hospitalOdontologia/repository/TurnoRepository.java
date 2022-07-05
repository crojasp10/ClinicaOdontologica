package com.hospitalOdontologia.hospitalOdontologia.repository;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository <Turno, Integer> {


    Turno save (Turno turno);

    Turno findById(int id);
    List<Turno> findAll();





}
