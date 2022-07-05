package com.hospitalOdontologia.hospitalOdontologia.controller;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import com.hospitalOdontologia.hospitalOdontologia.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/asignarTurno")
    public ResponseEntity insertarturno (@RequestBody Turno turno) {

        return ResponseEntity.ok(turnoService.insertarturno(turno));

    }


    @GetMapping("/getTurnos")
    public ResponseEntity<List<Turno>> listar () {
        System.out.println("Ingresamos a findAll");
        return ResponseEntity.ok(turnoRepository.findAll());

    }




}
