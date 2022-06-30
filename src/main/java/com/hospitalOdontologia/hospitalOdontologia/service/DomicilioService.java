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
import org.springframework.stereotype.Service;


@Service
public class DomicilioService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;

    public StringBuilder insertarturno (Domicilio domicilio) {
        System.out.println("Guarda el domicilio");

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

            domicilioRepository.save(domicilio);

        } else{
            System.out.println("No se pudo agregar");
        }
        result.append("Los datos ingresados son: ").append("Id ").append(domicilio.getId());
        return result;

    }






}
