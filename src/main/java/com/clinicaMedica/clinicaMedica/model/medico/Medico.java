package com.clinicaMedica.clinicaMedica.model.medico;

import com.clinicaMedica.clinicaMedica.model.prontuario.Prontuario;
import com.clinicaMedica.clinicaMedica.model.especialidade.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Table(name="medicos")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;
    @OneToMany(mappedBy = "medico")
    private List<Prontuario> prontuarios;
    @ManyToMany
    @JoinTable(
            name="medico_especialidade", //nome da tabela intermediaria
            joinColumns = @JoinColumn(name = "medico_id"), // FK para medico
            inverseJoinColumns = @JoinColumn(name = "especialidade_id") // FK para especialidade
    )
    private Set<Especialidade> especialidades = new HashSet<>();


}
