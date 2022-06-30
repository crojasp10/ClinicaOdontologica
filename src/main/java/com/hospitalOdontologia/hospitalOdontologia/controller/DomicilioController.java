package com.hospitalOdontologia.hospitalOdontologia.controller;

import com.hospitalOdontologia.hospitalOdontologia.beans.Domicilio;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import com.hospitalOdontologia.hospitalOdontologia.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class DomicilioController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private DomicilioService domicilioService;


    @PostMapping("/asignarDomicilio")
    public StringBuilder insertarturno (@RequestBody Domicilio domicilio) {

        StringBuilder result = new StringBuilder();;
        System.out.println(" los datos del domicilio son: "+ domicilio);
        System.out.println(" el id del domicilio es: "+ domicilio.getPaciente().getId());
        domicilioService.insertarturno(domicilio);
        result.append("Los datos ingresados son: ").append("Id ").append(domicilio.getId());
        return result;

    }



}
