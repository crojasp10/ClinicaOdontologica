package com.hospitalOdontologia.hospitalOdontologia.controller;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import com.hospitalOdontologia.hospitalOdontologia.service.TurnoService;
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
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/asignarTurno")
    //@ResponseStatus(HttpStatus.CREATED)
    public StringBuilder insertarturno (@RequestBody Turno turno) {

        StringBuilder result = new StringBuilder();
        turnoService.insertarturno(turno);
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
