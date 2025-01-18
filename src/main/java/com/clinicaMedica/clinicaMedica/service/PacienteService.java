package com.clinicaMedica.clinicaMedica.service;

import com.clinicaMedica.clinicaMedica.Repository.PacienteRepository;
import com.clinicaMedica.clinicaMedica.model.Paciente.Paciente;
import com.clinicaMedica.clinicaMedica.model.Paciente.PacienteRequestDto;
import com.clinicaMedica.clinicaMedica.model.Paciente.PacienteResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteResponseDto cadastrar(PacienteRequestDto dto){
        var paciente = new Paciente();
        paciente.setNome(dto.nome());
        paciente.setCpf(dto.cpf());
        paciente.setEmail(dto.email());
        paciente.setDataNascimento(dto.dataNascimento());
        paciente.setEndereco(dto.endereco());
        paciente.setBairro(dto.bairro());
        paciente.setCidade(dto.cidade());
        paciente.setUf(dto.uf());
        pacienteRepository.save(paciente);

        return new PacienteResponseDto(paciente);
    }

    public Page<PacienteResponseDto> listarTodos(Pageable pageable){
        Page<Paciente> pacientePage= pacienteRepository.findAll(pageable);

        return pacientePage.map(PacienteResponseDto::new);
    }

    public PacienteResponseDto listarPorId(Long id){

        var paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return new PacienteResponseDto(paciente);
    }

    public PacienteResponseDto alterar(Long id, PacienteRequestDto dto){
        var paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        System.out.println(paciente);
        if(!paciente.getNome().equalsIgnoreCase(dto.nome())){
            paciente.setNome(dto.nome());
        }
        if(!paciente.getCpf().equalsIgnoreCase(dto.cpf())){
            paciente.setCpf(dto.cpf());
        }
        if(!paciente.getEmail().equalsIgnoreCase(dto.cpf())){
            paciente.setCpf(dto.cpf());
        }
        if(!paciente.getDataNascimento().equals(dto.dataNascimento())){
            paciente.setDataNascimento(dto.dataNascimento());
        }
        if(!paciente.getEndereco().equalsIgnoreCase(dto.endereco())){
            paciente.setEndereco(dto.endereco());
        }
        if(!paciente.getBairro().equalsIgnoreCase(dto.bairro())){
            paciente.setBairro(dto.bairro());
        }
        if(!paciente.getCidade().equalsIgnoreCase(dto.cidade())){
            paciente.setCidade(dto.cidade());
        }
        if(!paciente.getUf().equalsIgnoreCase(dto.uf())){
            paciente.setUf(dto.uf());
        }
        pacienteRepository.save(paciente);

        return new PacienteResponseDto(paciente);
    }

    public void excluir(Long id){
        var paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        pacienteRepository.delete(paciente);
    }
}
