package com.clinicaMedica.clinicaMedica.model.prontuario;

import java.time.LocalDate;

public record ProntuarioResponseDto(
        Long id,
        String paciente,
        String medico,
        String diagnostico,
        String tratamento,
        LocalDate dataAtendimento
) {
    public ProntuarioResponseDto(Prontuario prontuario) {
        this(prontuario.getId(), prontuario.getPaciente().getNome(), prontuario.getMedico().getNome(),
             prontuario.getDiagnostico(), prontuario.getTratamento(), prontuario.getDataAtendimento());
    }
}
