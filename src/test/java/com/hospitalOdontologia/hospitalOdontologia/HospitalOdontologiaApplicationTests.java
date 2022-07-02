package com.hospitalOdontologia.hospitalOdontologia;

import com.hospitalOdontologia.hospitalOdontologia.beans.Odontologo;
import com.hospitalOdontologia.hospitalOdontologia.beans.Paciente;
import com.hospitalOdontologia.hospitalOdontologia.beans.Turno;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalOdontologiaApplicationTests {


	Odontologo odontologo = new Odontologo(1);
	Paciente paciente = new Paciente(2,"Carlos","Rojas","ww2223434","23-2-2020");
	Turno turno = new Turno(1,"2-23-2002",paciente,odontologo);



	@Test
	void verificarCarga() {


	}

}
