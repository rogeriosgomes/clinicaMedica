package com.clinicaMedica.clinicaMedica.model.especialidade;

import com.clinicaMedica.clinicaMedica.Enum.SimNao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EspecialidadeRequestDto(
        Long id,
        @NotNull(message = "O campo descrição tem que ser informado.")
        String descricao,
        @NotNull(message = "O campo aceita plano tem que ser informado.")
        SimNao aceitaPlano
) {
}
