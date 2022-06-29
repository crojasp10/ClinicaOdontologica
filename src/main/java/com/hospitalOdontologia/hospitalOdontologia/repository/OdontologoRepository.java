package com.hospitalOdontologia.hospitalOdontologia.repository;

import com.hospitalOdontologia.hospitalOdontologia.beans.Odontologo;
import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {

    List<Odontologo> findAll();

    Odontologo save(Odontologo odontologo);

    Odontologo findById(int id);


}

