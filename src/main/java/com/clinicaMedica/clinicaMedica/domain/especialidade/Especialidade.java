package com.clinicaMedica.clinicaMedica.domain.especialidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "especialidades")
@Entity(name = "especialidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    public Especialidade(String descricao) {
        this.descricao = descricao;
    }
}
