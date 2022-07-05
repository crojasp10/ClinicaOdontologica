package com.hospitalOdontologia.hospitalOdontologia.controller;


import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import com.hospitalOdontologia.hospitalOdontologia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin ( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST })
@RequestMapping("/paciente")
public class PacienteController {


    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private PacienteService pacienteService;


    @GetMapping("/getPacientes/{id}")
    public Paciente getPacienteById(@PathVariable(value = "id") int id) {

        System.out.println("Se encontro el paciente: "+ pacienteRepository.findById(id).getId());
        return pacienteRepository.findById(id);
    }


    @GetMapping("/getPacientes")
    public List<Paciente> listar () {
        System.out.println("Ingresamos a findAll");
        return pacienteRepository.findAll();

    }

    @PostMapping("/newPaciente")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertarPaciente(@RequestBody Paciente paciente) {

        pacienteRepository.save(paciente);

    }


    @DeleteMapping("/deletePaciente/{id}")
    public ResponseEntity deletePacienteById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el paciente");
        return pacienteService.deletePacienteById(id);
    }


    @PutMapping("/updatePaciente")
    public void updatePaciente( @RequestBody Paciente paciente){
         pacienteService.updatePaciente(paciente);
        System.out.println("Se modifica el paciente");

    }



    @GetMapping("/getPacientesNombre/{name}/{apellido}")
    public List <Paciente> listarNombres (@PathVariable(value = "name")String name, @PathVariable(value = "apellido") String apellido) {
        System.out.println("Ingresa a clientes nombre");
        return pacienteRepository.findAllNames(name, apellido);

    }




}
