package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
 
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService { 

    @Autowired
    private PacienteRepository pacienteRepository;

     

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
        Optional<Paciente> existingPaciente = pacienteRepository.findById(id);
        if (existingPaciente.isPresent()) {
            Paciente updatedPaciente = existingPaciente.get();
            updatedPaciente.setNombrePaciente(paciente.getNombrePaciente());
             return pacienteRepository.save(updatedPaciente);
        } else {
            return null; 
        }
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

 
}

