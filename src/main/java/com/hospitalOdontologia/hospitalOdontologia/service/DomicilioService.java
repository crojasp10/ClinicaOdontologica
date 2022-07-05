package com.hospitalOdontologia.hospitalOdontologia.service;

import com.hospitalOdontologia.hospitalOdontologia.beans.Domicilio;
import com.hospitalOdontologia.hospitalOdontologia.beans.Odontologo;
import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import com.hospitalOdontologia.hospitalOdontologia.repository.DomicilioRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.OdontologoRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class DomicilioService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;

    public ResponseEntity insertardomicilio (Domicilio domicilio) {

        ResponseEntity response = null;
        System.out.println("Se muestra el domicilio");
        System.out.println(domicilio);
        StringBuilder result = new StringBuilder();

        if (pacienteRepository.findById(domicilio.getPaciente().getId()) != null) {
            Paciente paciente = new Paciente();
            paciente = pacienteRepository.findById(domicilio.getPaciente().getId());
            System.out.println("El paciente id es : "+paciente.getId());


            System.out.println("Guarda el turno 1 con id: " + domicilio.getPaciente().getId() );


            domicilio.setDepartamento(domicilio.getDepartamento());
            domicilio.setCiudad(domicilio.getCiudad());
            domicilio.setDireccion(domicilio.getDireccion());
            domicilio.setPaciente(paciente);

            response = ResponseEntity.ok(domicilioRepository.save(domicilio));

        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }






}
