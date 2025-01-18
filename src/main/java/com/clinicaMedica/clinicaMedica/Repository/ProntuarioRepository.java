package com.clinicaMedica.clinicaMedica.Repository;

import com.clinicaMedica.clinicaMedica.model.prontuario.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}
