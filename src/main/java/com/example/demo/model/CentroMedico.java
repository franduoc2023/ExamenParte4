package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
 
@Entity
@Table(name = "centro_medico")
public class CentroMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_doctor", nullable = false)
    private String nombreDoctor;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "fecha_ocupada")
    private LocalDateTime fechaOcupada;

    @Column(name = "direccion_centro", nullable = false)
    private String direccionDelCentro;

@ManyToOne
@JoinColumn(name = "paciente_id")
@JsonBackReference
private Paciente paciente;

     public CentroMedico() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaOcupada() {
        return fechaOcupada;
    }

    public void setFechaOcupada(LocalDateTime fechaOcupada) {
        this.fechaOcupada = fechaOcupada;
    }

    public String getDireccionDelCentro() {
        return direccionDelCentro;
    }

    public void setDireccionDelCentro(String direccionDelCentro) {
        this.direccionDelCentro = direccionDelCentro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}