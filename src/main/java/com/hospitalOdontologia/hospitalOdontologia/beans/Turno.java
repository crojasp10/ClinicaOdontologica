package com.hospitalOdontologia.hospitalOdontologia.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "turno")
@NoArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name= "id")
    private int id;

    @Column(name="fecha")
    private String fecha;

    @ManyToOne( cascade = CascadeType.ALL,  fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente;



}
