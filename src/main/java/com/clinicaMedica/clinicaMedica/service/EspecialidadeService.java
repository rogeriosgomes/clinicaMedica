package com.clinicaMedica.clinicaMedica.service;

import com.clinicaMedica.clinicaMedica.Repository.EspecialidadeRespository;
import com.clinicaMedica.clinicaMedica.domain.especialidade.Especialidade;
import com.clinicaMedica.clinicaMedica.domain.especialidade.EspecialidadeRequestDto;
import com.clinicaMedica.clinicaMedica.domain.especialidade.EspecialidadeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRespository respository;

    public EspecialidadeResponseDto cadastrar(EspecialidadeRequestDto especialidadeDto){

        var especialidade = new Especialidade(especialidadeDto.descricao());
        respository.save(especialidade);

        return new EspecialidadeResponseDto(especialidade);
    }
    public Page<EspecialidadeResponseDto> listarTodos(Pageable pageable){

        List<Especialidade> especialidadeList = respository.findAll();

        var listespecialidade = especialidadeList.stream()
                                    .map(e -> new EspecialidadeResponseDto(e))
                                    .toList();

        return new PageImpl<>(listespecialidade, pageable, listespecialidade.size());

   }

   public EspecialidadeResponseDto listarPorId(Long id){
        Optional<Especialidade> especialidade = respository.findById(id);
        return new EspecialidadeResponseDto(especialidade.get());
   }

   public EspecialidadeResponseDto alterar(Long id, EspecialidadeRequestDto especialidadeDto){
        Optional<Especialidade> especialidade = respository.findById(id);

        especialidade.get().setDescricao(especialidadeDto.descricao());
        System.out.println(especialidade.get());
        respository.save(especialidade.get());
        var especialidadeResponseDto = new EspecialidadeResponseDto(especialidade.get());

        return especialidadeResponseDto;
   }

   public void excluir(Long id){

       Optional<Especialidade> especialidade = respository.findById(id);

       respository.delete(especialidade.get());

   }





}
