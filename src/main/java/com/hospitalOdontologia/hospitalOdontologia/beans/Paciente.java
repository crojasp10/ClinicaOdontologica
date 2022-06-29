package com.hospitalOdontologia.hospitalOdontologia.beans;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@ToString
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @OneToMany (mappedBy = "paciente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Turno> turnos;


    public Paciente() {
    }

    public Paciente(int id, String nombre, String apellido, List<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turnos = turnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurno(Turno turno) {
        turnos.add(turno);
    }
}