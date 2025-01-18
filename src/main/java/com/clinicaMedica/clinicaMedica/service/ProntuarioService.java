package com.clinicaMedica.clinicaMedica.service;

import com.clinicaMedica.clinicaMedica.Repository.MedicoRepository;
import com.clinicaMedica.clinicaMedica.Repository.PacienteRepository;
import com.clinicaMedica.clinicaMedica.Repository.ProntuarioRepository;
import com.clinicaMedica.clinicaMedica.model.prontuario.Prontuario;
import com.clinicaMedica.clinicaMedica.model.prontuario.ProntuarioRequestDto;
import com.clinicaMedica.clinicaMedica.model.prontuario.ProntuarioResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public ProntuarioResponseDto cadastrar(ProntuarioRequestDto dto){

        var prontuario = new Prontuario();
        var paciente = pacienteRepository.findById(dto.paciente()).orElseThrow(()->new RuntimeException("Paciente não encontrado"));
        var medico = medicoRepository.findById(dto.medico()).orElseThrow(()->new RuntimeException("Médico não encontrado"));

        prontuario.setPaciente(paciente);
        prontuario.setMedico(medico);
        prontuario.setDiagnostico(dto.diagnostico());
        prontuario.setTratamento(dto.tratamento());
        prontuario.setDataAtendimento(dto.dataAtendimento());

        prontuarioRepository.save(prontuario);

        return new ProntuarioResponseDto(prontuario);

    }

    public Page<ProntuarioResponseDto> listarTodos(Pageable pageable){

        var prontuarios = prontuarioRepository.findAll(pageable);

        return prontuarios.map(ProntuarioResponseDto::new);
    }

    public ProntuarioResponseDto listarPorId(Long id){
        var prontuario = prontuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Prontuario não encotrado"));

        return new ProntuarioResponseDto(prontuario);
    }

    public ProntuarioResponseDto alterar(Long id, ProntuarioRequestDto dto){
        var prontuario = prontuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Prontuario não encotrado"));

        if(!prontuario.getDiagnostico().equalsIgnoreCase(dto.diagnostico())){
            prontuario.setDiagnostico(dto.diagnostico());
        }
        if(!prontuario.getTratamento().equalsIgnoreCase(dto.tratamento())){
            prontuario.setTratamento(dto.tratamento());
        }
        if(!prontuario.getDataAtendimento().equals(dto.dataAtendimento())){
            prontuario.setDataAtendimento(dto.dataAtendimento());
        }

        prontuarioRepository.save(prontuario);

        return new ProntuarioResponseDto(prontuario);
    }

    public void excluir(Long id){
        var prontuario = prontuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Prontuario não encotrado"));

        prontuarioRepository.delete(prontuario);
    }
}
