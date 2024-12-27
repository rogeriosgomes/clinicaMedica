package com.clinicaMedica.clinicaMedica.model.especialidade;

import com.clinicaMedica.clinicaMedica.Enum.SimNao;
import com.clinicaMedica.clinicaMedica.Enum.SimNaoDeserializer;
import com.clinicaMedica.clinicaMedica.Enum.SimNaoSerializer;
import com.clinicaMedica.clinicaMedica.model.medico.Medico;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "especialidades")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @JsonDeserialize(using = SimNaoDeserializer.class)
    @JsonSerialize(using = SimNaoSerializer.class)
    private SimNao aceitaPlano;
    @ManyToMany(mappedBy = "especialidades", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Medico> medicos = new HashSet<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Especialidade that = (Especialidade) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", aceitaPlano=" + aceitaPlano +
                '}';
    }
}
