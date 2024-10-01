package com.example.demo.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.example.demo.model.Paciente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void pacienteEnvioTest() {
        Paciente paciente = new Paciente();
        paciente.setNombrePaciente("paciente prueba");

         Paciente resultado = pacienteRepository.save(paciente);

         assertNotNull(resultado.getId());
        
         assertEquals("paciente prueba", resultado.getNombrePaciente());
    }
}

