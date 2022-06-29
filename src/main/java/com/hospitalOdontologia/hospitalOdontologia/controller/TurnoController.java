package com.hospitalOdontologia.hospitalOdontologia.controller;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class TurnoController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;

    @PostMapping("/asignarTurno")
    //@ResponseStatus(HttpStatus.CREATED)
    public StringBuilder insertarturno (@RequestBody Turno turno) {
        System.out.println("Guarda el turno");

        System.out.println("Se muestra el turno");
        System.out.println(turno);
        StringBuilder result = new StringBuilder();

        if (pacienteRepository.findById(turno.getPaciente().getId()) != null) {
            Paciente paciente = pacienteRepository.findById(turno.getPaciente().getId());
            System.out.println("Guarda el turno 1 con id: " + turno.getPaciente().getId() );
            //Turno turno1 = new Turno();
            turno.setFecha(turno.getFecha());
            turno.setId(turno.getId());
            turno.setPaciente(paciente);
            turnoRepository.save(turno);

        } else{
            System.out.println("No se pudo agregar");
        }
        result.append("Los datos ingresados son: ").append("Id ").append(turno.getId()).append(" El nombre es: ")
                .append(turno.getFecha());
        return result;

    }
    @GetMapping("/getTurnos")
    public List<Turno> listar () {
        System.out.println("Ingresamos a findAll");
        return turnoRepository.findAll();

    }



}
