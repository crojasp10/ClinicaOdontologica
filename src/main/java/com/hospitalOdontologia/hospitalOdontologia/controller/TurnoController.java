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
    public StringBuilder insertarturno (@RequestBody Turno turno) {

        StringBuilder result = new StringBuilder();
        Turno turno1 = turno;
        System.out.println(" los datos del turno son: "+ turno1);
        System.out.println(" el id del turno es: "+ turno1.getPaciente().getId());
        turnoService.insertarturno(turno);
        result.append("Los datos ingresados son: ").append("Id ").append(turno.getId()).append(" El nombre es: ")
                .append(turno.getFecha());
        return result;

    }

    @GetMapping("/getTurnosByPaciente")
    public List<Turno> listarTurnoByPaciente (@PathVariable(value = "id")Integer id){
        System.out.println("Ingresa al metodo turno By id: " + id);
        return turnoRepository.findAll();
        //return turnoRepository.findTurnoByIdPaciente(id);
    }


    @GetMapping("/getTurnos")
    public List<Turno> listar () {
        System.out.println("Ingresamos a findAll");
        return turnoRepository.findAll();

    }




}
