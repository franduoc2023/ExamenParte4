package com.example.demo.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceImplTest {

    @Mock
    private PacienteRepository pacienteRepositoriomock;

    @InjectMocks
    private PacienteServiceImpl pacienteService;

    @Test 
    public void guardarPacienteTest(){
        Paciente paciente = new Paciente();
        paciente.setNombrePaciente("roberto");

         when(pacienteRepositoriomock.save(any(Paciente.class))).thenReturn(paciente);

         Paciente resultado = pacienteService.createPaciente(paciente);

     
        assertEquals("roberto", resultado.getNombrePaciente());
    }
}
