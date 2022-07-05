package com.hospitalOdontologia.hospitalOdontologia.service;

import com.hospitalOdontologia.hospitalOdontologia.beans.Odontologo;
import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import com.hospitalOdontologia.hospitalOdontologia.repository.OdontologoRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Service
public class TurnoService  {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;


    public ResponseEntity insertarturno (Turno turno) {
        ResponseEntity response = null;

        System.out.println("Se muestra el turno");
        System.out.println(turno);
        //System.out.println("id paciente turno: "+ turno.getPaciente());


        if (pacienteRepository.findById(turno.getPaciente().getId()) != null &&
                odontologoRepository.findById((turno.getOdontologo().getId())) != null) {
            Paciente paciente = new Paciente();
             paciente = pacienteRepository.findById(turno.getPaciente().getId());
            System.out.println("El paciente id es : "+paciente.getId());

            Odontologo odontologo = new Odontologo();
            odontologo = odontologoRepository.findById(turno.getOdontologo().getId());

            System.out.println("Guarda el turno 1 con id: " + turno.getPaciente().getId() + "y odontologo id:"+ turno.getOdontologo().getId() );


            turno.setFecha(turno.getFecha());
            turno.setPaciente(paciente);
            turno.setOdontologo(odontologo);
            response = ResponseEntity.ok(turnoRepository.save(turno));

        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }









}
