package com.example.demo.controller;

import com.example.demo.model.Paciente;
import com.example.demo.repository.CentroMedicoRepository;
import com.example.demo.service.PacienteServiceImpl;
import org.junit.jupiter.api.Test;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@WebMvcTest(CitasController.class)
public class PacienteControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteServiceImpl pacienteServicioMock;
@MockBean
private CentroMedicoRepository centroMedicoRepositoryMock;
    @Test
    public void obtenerTodosTest() throws Exception {
        Paciente paciente1 = new Paciente();
        paciente1.setNombrePaciente("Paciente prueba");
        paciente1.setId(1L);

        Paciente paciente2 = new Paciente();
        paciente2.setNombrePaciente("Paciente prueba dos");
        paciente2.setId(2L);

        List<Paciente> pacientes = Arrays.asList(paciente1, paciente2);
        
       
        when(pacienteServicioMock.getAllPacientes()).thenReturn(pacientes);
 
        mockMvc.perform(MockMvcRequestBuilders.get("/citas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombrePaciente", is("Paciente prueba")))
                .andExpect(jsonPath("$[1].nombrePaciente", is("Paciente prueba dos")));
    }
}