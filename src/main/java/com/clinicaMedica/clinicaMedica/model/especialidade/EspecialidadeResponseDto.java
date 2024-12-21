package com.clinicaMedica.clinicaMedica.model.especialidade;

import com.clinicaMedica.clinicaMedica.Enum.SimNao;

public record EspecialidadeResponseDto(
        Long id,
        String descricao,
        SimNao aceitaPlano
) {

    public EspecialidadeResponseDto(Especialidade especialidade){
        this(especialidade.getId(), especialidade.getDescricao(), especialidade.getAceitaPlano());
    }
}
