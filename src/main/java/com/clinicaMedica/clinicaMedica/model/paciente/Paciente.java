package com.clinicaMedica.clinicaMedica.model.paciente;

import com.clinicaMedica.clinicaMedica.model.prontuario.Prontuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "pacientes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true, nullable = true)
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios;
}
