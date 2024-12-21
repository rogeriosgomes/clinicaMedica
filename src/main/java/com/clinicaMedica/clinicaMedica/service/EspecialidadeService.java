package com.clinicaMedica.clinicaMedica.service;


import com.clinicaMedica.clinicaMedica.Repository.EspecialidadeRespository;
import com.clinicaMedica.clinicaMedica.model.especialidade.Especialidade;
import com.clinicaMedica.clinicaMedica.model.especialidade.EspecialidadeRequestDto;
import com.clinicaMedica.clinicaMedica.model.especialidade.EspecialidadeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {


    private final EspecialidadeRespository respository;

    public EspecialidadeResponseDto cadastrar(EspecialidadeRequestDto dto){

        var especialidade = new Especialidade();
        especialidade.setDescricao(dto.descricao());
        especialidade.setAceitaPlano(dto.aceitaPlano());
        respository.save(especialidade);

        return new EspecialidadeResponseDto(especialidade);
    }
    public Page<EspecialidadeResponseDto> listarTodos(Pageable pageable){

        Page<Especialidade> especialidadePage = respository.findAll(pageable);
        return especialidadePage.map(EspecialidadeResponseDto::new);

   }

   public EspecialidadeResponseDto listarPorId(Long id){
        var especialidade = respository.findById(id).orElseThrow(()->new RuntimeException("Especialidade não encontrada."));
        return new EspecialidadeResponseDto(especialidade);
   }

   public EspecialidadeResponseDto alterar(Long id, EspecialidadeRequestDto especialidadeDto){
        var especialidade = respository.findById(id).orElseThrow(()->new RuntimeException("Especialidade não encontrada."));
        especialidade.setDescricao(especialidadeDto.descricao());
        especialidade.setAceitaPlano(especialidadeDto.aceitaPlano());
        respository.save(especialidade);

        return new EspecialidadeResponseDto(especialidade);
   }

   public void excluir(Long id){

       var especialidade = respository.findById(id).orElseThrow(()-> new RuntimeException("Especialidade não encontrada."));

       respository.delete(especialidade);

   }





}
