package com.clinicaMedica.clinicaMedica.domain.medico;

import com.clinicaMedica.clinicaMedica.domain.especialidade.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record MedicoRequestDto( @NotBlank
                                String nome,
                                @NotBlank
                                @Pattern(regexp = "\\d{4,6}")
                                String crm,
                                Especialidade especialidade) {
}
