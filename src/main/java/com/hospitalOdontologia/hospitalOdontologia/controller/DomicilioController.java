package com.hospitalOdontologia.hospitalOdontologia.controller;

import com.hospitalOdontologia.hospitalOdontologia.beans.Domicilio;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import com.hospitalOdontologia.hospitalOdontologia.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private DomicilioService domicilioService;


    @PostMapping("/asignarDomicilio")
    public ResponseEntity insertarDomicilio (@RequestBody Domicilio domicilio) {

        System.out.println(" los datos del domicilio son: "+ domicilio);
        return ResponseEntity.ok(domicilioService.insertardomicilio(domicilio));


    }



}
