package com.clinicaMedica.clinicaMedica.Repository;

import com.clinicaMedica.clinicaMedica.model.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
