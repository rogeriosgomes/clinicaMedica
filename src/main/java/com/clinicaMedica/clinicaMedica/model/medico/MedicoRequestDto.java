package com.clinicaMedica.clinicaMedica.model.medico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Set;

public record MedicoRequestDto( @NotBlank
                                String nome,
                                @NotBlank
                                @Pattern(regexp = "\\d{4,6}")
                                String crm,
                                Set<Long> especialidadesIds // IDs das especialidades
                                ) {
}
