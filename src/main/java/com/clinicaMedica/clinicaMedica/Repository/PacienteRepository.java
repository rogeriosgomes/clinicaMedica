package com.clinicaMedica.clinicaMedica.Repository;

import com.clinicaMedica.clinicaMedica.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsByCpf(String cpf);
}
