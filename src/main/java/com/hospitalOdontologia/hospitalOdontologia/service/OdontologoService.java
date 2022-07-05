package com.hospitalOdontologia.hospitalOdontologia.service;

import com.hospitalOdontologia.hospitalOdontologia.beans.Odontologo;
import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.repository.OdontologoRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.PacienteRepository;
import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private TurnoRepository turnoRepository;


    public ResponseEntity updateOdontologo( Odontologo odontologo) {

        ResponseEntity response = null;
        Odontologo odontologo1 = odontologoRepository.findById(odontologo.getId());

        if (odontologoRepository.findById(odontologo.getId()) != null) {
            System.out.println("El paciente es: "+odontologo);
            odontologo1.setId(odontologo.getId());
            odontologo1.setNombre(odontologo.getNombre());
            odontologo1.setApellido(odontologo.getApellido());
            odontologo1.setMatricula(odontologo.getMatricula());

            response = ResponseEntity.ok(odontologoRepository.save(odontologo1));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }



    public ResponseEntity deleteOdontologoById(int id) {

        ResponseEntity response = null;

        if(odontologoRepository.findById(id)==null){
            response = new ResponseEntity( HttpStatus.NOT_FOUND);
        }else{
            odontologoRepository.deleteById(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }












}
