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
@RequestMapping("/crud")
public class OdontologoController {

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/newOdontologo")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertarOdontologo(@RequestBody Odontologo odontologo) {

        odontologoRepository.save(odontologo);

    }


    @GetMapping("/getOdontologo/{id}")
    public Odontologo getOdontologoById(@PathVariable(value = "id") int id) {

        System.out.println("Se encontro el paciente: "+ odontologoRepository.findById(id).getId());
        return odontologoRepository.findById(id);
    }


    @GetMapping("/getOdontologos")
    public List<Odontologo> listar () {
        System.out.println("Ingresamos a findAll");
        return odontologoRepository.findAll();

    }

    @DeleteMapping("/deleteOdontologo/{id}")
    public ResponseEntity deleteOdontologoById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el paciente");
        return odontologoService.deleteOdontologoById(id);
    }


    @PutMapping("/updateOdontologo")
    public void updatePaciente( @RequestBody Odontologo odontologo){
        odontologoService.updateOdontologo(odontologo);
        System.out.println("Se modifica el paciente");

    }





}
