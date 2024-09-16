package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.CentroMedico;
import java.time.LocalDateTime;
import java.util.List;



public interface CentroMedicoRepository extends JpaRepository<CentroMedico, Long>{
    List<CentroMedico> findByFechaHora(LocalDateTime fechaHora);

} 

 