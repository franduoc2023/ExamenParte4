package com.example.demo.controller;

import com.example.demo.repository.CentroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private CentroMedicoRepository centroMedicoRepository;  

    @GetMapping
    public List<Paciente> getPacientes() {
        return pacienteService.getAllPacientes();
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
//https://es.stackoverflow.com/questions/310446/c%C3%B3mo-calcular-las-horas-que-faltan-con-localtime
     @GetMapping("/disponibilidad")
    public ResponseEntity<List<LocalDateTime>> consultarDisponibilidad(@RequestParam String fecha) {
        LocalDate fechaBuscada = LocalDate.parse(fecha);
        LocalTime horaInicio = LocalTime.of(8, 30);
        LocalTime horaFin = LocalTime.of(18, 0);

         List<LocalDateTime> posiblesHoras = Stream.iterate(LocalDateTime.of(fechaBuscada, horaInicio),
                hora -> hora.plusMinutes(30))
                .limit((horaFin.toSecondOfDay() - horaInicio.toSecondOfDay()) / 1800)
                .collect(Collectors.toList());

         List<LocalDateTime> horasDisponibles = posiblesHoras.stream()
                .filter(hora -> centroMedicoRepository.findByFechaHora(hora).isEmpty())
                .collect(Collectors.toList());

        return ResponseEntity.ok(horasDisponibles);
    }


    @PutMapping("/paciente/{id}")
    public void actualizarNombrePaciente(@PathVariable Long id, @RequestBody String nuevoNombre) {
        Paciente paciente = new Paciente();
        paciente.setNombrePaciente(nuevoNombre);
        pacienteService.updatePaciente(id, paciente);
    }

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente nuevoPaciente) {
        Paciente pacienteGuardado = pacienteService.createPaciente(nuevoPaciente);
        return ResponseEntity.ok(pacienteGuardado);
    }
}