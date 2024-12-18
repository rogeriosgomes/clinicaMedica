package com.clinicaMedica.clinicaMedica.domain.especialidade;

import jakarta.validation.constraints.NotBlank;

public record EspecialidadeRequestDto(
        Long id,
        @NotBlank
        String descricao
) {
}
