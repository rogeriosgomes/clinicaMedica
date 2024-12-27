package com.clinicaMedica.clinicaMedica.service;

import com.clinicaMedica.clinicaMedica.Repository.EspecialidadeRespository;
import com.clinicaMedica.clinicaMedica.Repository.MedicoRepository;
import com.clinicaMedica.clinicaMedica.model.especialidade.Especialidade;
import com.clinicaMedica.clinicaMedica.model.especialidade.EspecialidadeRequestDto;
import com.clinicaMedica.clinicaMedica.model.especialidade.EspecialidadeResponseDto;
import com.clinicaMedica.clinicaMedica.model.medico.Medico;
import com.clinicaMedica.clinicaMedica.model.medico.MedicoRequestDto;
import com.clinicaMedica.clinicaMedica.model.medico.MedicoResponseDto;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MedicoService {

    @Autowired
    private  MedicoRepository medicoRepository;
    @Autowired
    private EspecialidadeRespository especialidadeRespository;



    public MedicoResponseDto cadastrar(MedicoRequestDto medicoRequestDto) {
        var medico = new Medico();

        medico.setNome(medicoRequestDto.nome());
        medico.setCrm(medicoRequestDto.crm());
        Set<Especialidade> especialidades = especialidadeRespository.findAllById(medicoRequestDto.especialidadesIds())
                        .stream().collect(Collectors.toSet());
        medico.setEspecialidades(especialidades);

        medicoRepository.save(medico);

        return toDto(medico);
    }


    public Page<MedicoResponseDto> listar(Pageable pageable) {


          List<MedicoResponseDto> medicos = medicoRepository.findAll(pageable)
                  .stream().map(this::toDto).collect(Collectors.toList());


          return new PageImpl<>(medicos, pageable, medicos.size());

    }



    public MedicoResponseDto listarPorId(Long id) {

          var medico = medicoRepository.findById(id).orElseThrow(()-> new RuntimeException("Médico não encontrado"));

          return toDto(medico);

    }

    public MedicoResponseDto alterar(Long id, MedicoRequestDto medicoRequestDto) {

        var medico = medicoRepository.findById(id).orElseThrow(()->new RuntimeException("Médico não encontrado"));
        medico.setNome(medicoRequestDto.nome());
        medico.setCrm(medicoRequestDto.crm());
        Set<Especialidade> especialidades = especialidadeRespository.findAllById(medicoRequestDto.especialidadesIds())
                .stream().collect(Collectors.toSet());
        medico.setEspecialidades(especialidades);

        medicoRepository.save(medico);

        return toDto(medico);
    }

    public void excluir(Long id) {

        var medico = medicoRepository.findById(id).orElseThrow(()->new RuntimeException("Médico não encontrado"));

        medicoRepository.delete(medico);

    }

//    private Set<Especialidade> listaDeEspecialidades(Set<Long> especialidadesIds ){
//
//        return especialidadesIds.stream()
//                .map(id -> especialidadeRespository.findById(id)
//                        .orElseThrow(() -> new RuntimeException("Especialidades não encontradas")))
//                .collect(Collectors.toSet());
//
//    }

    private MedicoResponseDto toDto(Medico medico) {

        Set<String> especialidades = medico.getEspecialidades().stream()
                .map(Especialidade::getDescricao)
                .collect(Collectors.toSet());

        return new MedicoResponseDto(medico.getId(), medico.getNome(), medico.getCrm(), especialidades);

    }


}
