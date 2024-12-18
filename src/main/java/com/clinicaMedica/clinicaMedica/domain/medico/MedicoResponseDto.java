package com.clinicaMedica.clinicaMedica.domain.medico;

import com.clinicaMedica.clinicaMedica.domain.especialidade.Especialidade;


public record MedicoResponseDto( Long id,
                                 String nome,
                                 String crm,
                                 String especialidade
) {

    public MedicoResponseDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade().getDescricao());
    }
}
