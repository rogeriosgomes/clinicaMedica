package com.clinicaMedica.clinicaMedica.model.prontuario;

import com.clinicaMedica.clinicaMedica.model.paciente.Paciente;
import com.clinicaMedica.clinicaMedica.model.medico.Medico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;
    private String diagnostico;
    private String tratamento;
    private LocalDate dataAtendimento;

}
