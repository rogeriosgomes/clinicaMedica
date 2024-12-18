package com.clinicaMedica.clinicaMedica.domain.medico;

import com.clinicaMedica.clinicaMedica.domain.especialidade.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Especialidade especialidade;

    public Medico(MedicoRequestDto medicoRequestDto) {
        this.nome = medicoRequestDto.nome();
        this.crm = medicoRequestDto.crm();
        this.especialidade = medicoRequestDto.especialidade();

    }


}
