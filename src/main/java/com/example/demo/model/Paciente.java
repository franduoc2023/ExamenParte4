package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_paciente", nullable = false)
    private String nombrePaciente;

     @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CentroMedico> centrosMedicos;

     public Paciente() {}

    // Constructor con parámetros
    public Paciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public List<CentroMedico> getCentrosMedicos() {
        return centrosMedicos;
    }

    public void setCentrosMedicos(List<CentroMedico> centrosMedicos) {
        this.centrosMedicos = centrosMedicos;
    }
}