package com.clinicaMedica.clinicaMedica.model.medico;


import com.clinicaMedica.clinicaMedica.model.especialidade.Especialidade;

import java.util.Set;
import java.util.stream.Collectors;


public record MedicoResponseDto(Long id,
                                String nome,
                                String crm,
                                Set<String> especialidades

) {


    public MedicoResponseDto(Long id, String nome, String crm, Set<String> especialidades) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidades = especialidades;
    }






}
