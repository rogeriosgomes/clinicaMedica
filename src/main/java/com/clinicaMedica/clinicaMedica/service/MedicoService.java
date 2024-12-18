package com.clinicaMedica.clinicaMedica.service;

import com.clinicaMedica.clinicaMedica.Repository.MedicoRepository;
import com.clinicaMedica.clinicaMedica.domain.medico.Medico;
import com.clinicaMedica.clinicaMedica.domain.medico.MedicoRequestDto;
import com.clinicaMedica.clinicaMedica.domain.medico.MedicoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public MedicoResponseDto cadastrar(MedicoRequestDto medicoRequestDto) {
        var medico = new Medico(medicoRequestDto);
        medicoRepository.save(medico);

        return new MedicoResponseDto(medico);
    }

    public Page<MedicoResponseDto> listar(Pageable pageable) {

        List<Medico> medicos = medicoRepository.findAll();

        var medicosResponseDto = medicos.stream()
                                .map(medico -> new MedicoResponseDto(medico))
                                .toList();

        return new PageImpl<>(medicosResponseDto, pageable, medicosResponseDto.size());

    }

    public MedicoResponseDto listarPorId(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);

        return  new MedicoResponseDto(medico.get());

    }

    public MedicoResponseDto alterar(Long id, MedicoRequestDto medicoRequestDto) {
        Optional<Medico> medico = medicoRepository.findById(id);
        medico.get().setNome(medicoRequestDto.nome());
        medico.get().setCrm(medicoRequestDto.crm());
        medico.get().setEspecialidade(medicoRequestDto.especialidade());

        medicoRepository.save(medico.get());

        return new MedicoResponseDto(medico.get());
    }

    public void excluir(Long id) {

        Optional<Medico> medico = medicoRepository.findById(id);

        medicoRepository.delete(medico.get());
    }


}
