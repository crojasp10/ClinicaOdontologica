package com.hospitalOdontologia.hospitalOdontologia.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "turno")

public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name= "id")
    private int id;

    @Column(name="fecha")
    private String fecha;


    @ManyToOne(  fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente;
/*

    @ManyToOne( cascade = CascadeType.ALL,  fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "odontologo_id",referencedColumnName = "id")
    private Odontologo odontologo;
*/

}
