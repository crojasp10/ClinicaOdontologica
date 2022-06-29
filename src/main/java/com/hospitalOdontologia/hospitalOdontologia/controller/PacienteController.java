package com.hospitalOdontologia.hospitalOdontologia.controller;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/crud")
public class PacienteController {


    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;


    @PostMapping("/newPaciente")
    @ResponseStatus(HttpStatus.CREATED)
    public StringBuilder insertarPaciente(@RequestBody Paciente paciente) {


        System.out.println("En metodo save");
        pacienteRepository.save(paciente);
        System.out.println(paciente.getId());
        System.out.println(paciente);

        StringBuilder result = new StringBuilder();
        result.append("Los datos ingresados son: ").append("Id ").append(paciente.getId()).append(" El nombre es: ")
                .append(paciente.getNombre());
        return result;
    }

    @GetMapping("/getPaciente/{id}")
    public Paciente getPacienteById(@PathVariable(value = "id") int id) {

        System.out.println("Se encontro el paciente: "+ pacienteRepository.findById(id).getId());
        return pacienteRepository.findById(id);
    }


    @GetMapping("/getPacientes")
    public List<Paciente> listar () {
        System.out.println("Ingresamos a findAll");
        return pacienteRepository.findAll();

    }



}
