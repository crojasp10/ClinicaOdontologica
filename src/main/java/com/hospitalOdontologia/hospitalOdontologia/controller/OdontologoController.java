package com.hospitalOdontologia.hospitalOdontologia.controller;

import com.hospitalOdontologia.hospitalOdontologia.beans.Odontologo;
import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.repository.OdontologoRepository;
import com.hospitalOdontologia.hospitalOdontologia.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin ( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST })
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/newOdontologo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity insertarOdontologo(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoRepository.save(odontologo));

    }


    @GetMapping("/getOdontologo/{id}")
    public ResponseEntity<Odontologo> getOdontologoById(@PathVariable(value = "id") int id) {

        Odontologo odontologo = odontologoRepository.findById(id);
        System.out.println("Se encontro el paciente: "+ odontologoRepository.findById(id).getId());
        return ResponseEntity.ok(odontologo);
    }


    @GetMapping("/getOdontologos")
    public ResponseEntity<List<Odontologo>> listar () {
        System.out.println("Ingresamos a findAll");
        return ResponseEntity.ok(odontologoRepository.findAll());

    }

    @DeleteMapping("/deleteOdontologo/{id}")
    public ResponseEntity deleteOdontologoById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el paciente");
        return odontologoService.deleteOdontologoById(id);
    }


    @PutMapping("/updateOdontologo")
    public ResponseEntity updatePaciente( @RequestBody Odontologo odontologo){
        System.out.println("Se modifica el paciente");
        return odontologoService.updateOdontologo(odontologo);


    }





}
