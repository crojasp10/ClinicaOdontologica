package com.hospitalOdontologia.hospitalOdontologia.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "odontologo")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "matricula")
    private  String matricula;

    @JsonIgnore
    @OneToMany (mappedBy = "odontologo",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Turno> turnos;







}
