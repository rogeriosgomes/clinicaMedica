package com.clinicaMedica.clinicaMedica.model.prontuario;

import java.time.LocalDate;

public record ProntuarioRequestDto(
        Long paciente,
        Long medico,
        String diagnostico,
        String tratamento,
        LocalDate dataAtendimento
) {
}
