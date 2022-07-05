package com.hospitalOdontologia.hospitalOdontologia.service;

import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;



    public ResponseEntity updatePaciente( Paciente paciente) {

        ResponseEntity response = null;
        Paciente paciente1 = pacienteRepository.findById(paciente.getId());

        if (pacienteRepository.findById(paciente.getId()) != null) {
            System.out.println("El paciente es: "+paciente);
            paciente1.setId(paciente.getId());
            paciente1.setNombre(paciente.getNombre());
            paciente1.setApellido(paciente.getApellido());
            paciente1.setDni(paciente.getDni());
            paciente1.setFechaDeAlta(paciente.getFechaDeAlta());

            response = ResponseEntity.ok(pacienteRepository.save(paciente1));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return response;
    }


    public ResponseEntity deletePacienteById(int id) {

        ResponseEntity response = null;
        if(pacienteRepository.findById(id)==null){
            response = new ResponseEntity( HttpStatus.NOT_FOUND);
        }else{
            pacienteRepository.deleteById(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }



    }









