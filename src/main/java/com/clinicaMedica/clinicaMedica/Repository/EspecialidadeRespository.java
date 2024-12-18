package com.clinicaMedica.clinicaMedica.Repository;

import com.clinicaMedica.clinicaMedica.domain.especialidade.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRespository extends JpaRepository<Especialidade, Long> {
}
