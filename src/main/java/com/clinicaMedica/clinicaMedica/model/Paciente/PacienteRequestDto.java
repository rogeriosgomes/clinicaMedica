package com.clinicaMedica.clinicaMedica.model.Paciente;

import com.clinicaMedica.clinicaMedica.infra.Anotacao.CpfUnico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PacienteRequestDto(
        @NotBlank(message = "O nome não pode estar vazio")
        String nome,
        @NotBlank(message = "O CPF não pode estar vazio")
        @CPF(message = "Cpf informado é incorreto")
        @CpfUnico
        String cpf,
        @NotBlank(message = "O email não pode estar vazio")
        @Email(message = "email informado é incorreto")
        String email,
      //  @NotBlank(message = "a data de nascimento não pode estar vazio")
        LocalDate dataNascimento,
        String endereco,
        String bairro,
        String cidade,
        String uf
) {
}
