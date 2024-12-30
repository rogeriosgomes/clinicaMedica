package com.clinicaMedica.clinicaMedica.model.Prontuario;

import com.clinicaMedica.clinicaMedica.model.Paciente.Paciente;
import com.clinicaMedica.clinicaMedica.model.medico.Medico;
import java.time.LocalDate;

public record ProntuarioRequestDto(
        Long paciente,
        Long medico,
        String diagnostico,
        String tratamento,
        LocalDate dataAtendimento
) {
}
