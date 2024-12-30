package com.clinicaMedica.clinicaMedica.infra.Anotacao;

import com.clinicaMedica.clinicaMedica.Repository.PacienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CpfUnicoValidator implements ConstraintValidator<CpfUnico, String> {

    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isBlank()) {
            return true; // Deixe outras validações como @NotBlank lidarem com campos vazios ou nulos
        }
        return !pacienteRepository.existsByCpf(cpf);
    }
}
