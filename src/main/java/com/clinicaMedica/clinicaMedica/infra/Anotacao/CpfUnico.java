package com.clinicaMedica.clinicaMedica.infra.Anotacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CpfUnicoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfUnico {

    String message() default "O CPF já está cadastrado.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
