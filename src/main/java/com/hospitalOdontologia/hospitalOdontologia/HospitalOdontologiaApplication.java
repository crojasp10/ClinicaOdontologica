package com.hospitalOdontologia.hospitalOdontologia;

import com.hospitalOdontologia.hospitalOdontologia.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HospitalOdontologiaApplication {

	@Autowired
	TurnoRepository turnoRepository;


	public static void main(String[] args) {
		SpringApplication.run(HospitalOdontologiaApplication.class, args);




	}


}