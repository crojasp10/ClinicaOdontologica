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
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "fechaDeAlta")
    private String fechaDeAlta;

    @JsonIgnore
    @OneToMany (mappedBy = "paciente",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Turno> turnos;

    public Paciente(int id, String nombre, String apellido, String dni, String fechaDeAlta) {
        this.id = id;

    }

    public int getId() {
        return id;
    }
}