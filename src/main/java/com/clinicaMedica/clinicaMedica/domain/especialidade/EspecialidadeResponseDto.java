package com.clinicaMedica.clinicaMedica.domain.especialidade;

public record EspecialidadeResponseDto(
        Long id,
        String descricao
) {

    public EspecialidadeResponseDto(Especialidade especialidade){
        this(especialidade.getId(), especialidade.getDescricao());
    }
}
