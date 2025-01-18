package com.clinicaMedica.clinicaMedica.model.paciente;

import java.time.LocalDate;

public record PacienteResponseDto(
        Long id,
         String nome,
         String cpf,
         String email,
         LocalDate dataNascimento,
         String endereco,
         String bairro,
         String cidade,
         String uf
) {
    public PacienteResponseDto(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getDataNascimento(),
                paciente.getEndereco(), paciente.getBairro(), paciente.getCidade(), paciente.getUf());
    }
}
