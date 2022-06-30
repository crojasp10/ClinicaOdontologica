package com.hospitalOdontologia.hospitalOdontologia.beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

Odontologo odontologo = new Odontologo(1);
    Paciente paciente = new Paciente(2,"Carlos","Rojas","ww2223434","23-2-2020");
    Turno turno = new Turno(1,"2-23-2002",paciente,odontologo);




    @Test
    void mostrarId(){
        assertEquals(1,turno.getPaciente().getId());
    }

}