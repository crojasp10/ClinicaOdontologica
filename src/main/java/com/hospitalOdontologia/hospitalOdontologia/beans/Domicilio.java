package com.hospitalOdontologia.hospitalOdontologia.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "domicilio")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="direccion")
    private String direccion;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="departamento")
    private String departamento;

    @OneToOne (fetch = FetchType.LAZY,optional = false)
    @ JoinColumn ( name = "domicilio_paciente_id" )
    private Paciente paciente;

}
