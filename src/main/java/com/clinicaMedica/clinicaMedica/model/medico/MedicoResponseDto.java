package com.clinicaMedica.clinicaMedica.model.medico;


public record MedicoResponseDto( Long id,
                                 String nome,
                                 String crm,
                                 String especialidade
) {

    public MedicoResponseDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidades().toString());
    }
}
