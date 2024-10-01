package com.example.demo.service;

import com.example.demo.model.Paciente;
import java.util.List;
import java.util.Optional;

// Declaración correcta de la interfaz PacienteService
public interface PacienteService {
    List<Paciente> getAllPacientes();   
    Optional<Paciente> getPacienteById(Long id);
    Paciente createPaciente(Paciente paciente);   
    Paciente updatePaciente(Long id, Paciente paciente);
    void deletePaciente(Long id);
  
}