package com.hospitalOdontologia.hospitalOdontologia.service;

import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class TurnoService  {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;


    public StringBuilder insertarturno (Turno turno) {
        System.out.println("Guarda el turno");

        System.out.println("Se muestra el turno");
        System.out.println(turno);
        StringBuilder result = new StringBuilder();

        if (pacienteRepository.findById(turno.getPaciente().getId()) != null) {
            Paciente paciente = new Paciente();
             paciente = pacienteRepository.findById(turno.getPaciente().getId());
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



}
