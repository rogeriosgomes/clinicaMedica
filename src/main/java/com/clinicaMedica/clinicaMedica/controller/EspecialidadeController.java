package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.model.especialidade.EspecialidadeRequestDto;
import com.clinicaMedica.clinicaMedica.model.especialidade.EspecialidadeResponseDto;
import com.clinicaMedica.clinicaMedica.service.EspecialidadeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/especialidade")
@RequiredArgsConstructor
public class EspecialidadeController {


    private final EspecialidadeService service;


    @PostMapping
    private ResponseEntity<EspecialidadeResponseDto> cadastrar(@RequestBody  @Valid EspecialidadeRequestDto dto,
                                                               UriComponentsBuilder uriBuilder){
        var especialidade = service.cadastrar(dto);
        var uri = uriBuilder.path("/especialidade/{id}")
                .buildAndExpand(especialidade.id()).toUri();

        return ResponseEntity.created(uri).body(especialidade);
    }


    @GetMapping
    public ResponseEntity<Page<EspecialidadeResponseDto>> listarTodos(Pageable pageable){
        var especialidades = service.listarTodos(pageable);

        return ResponseEntity.ok(especialidades);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDto> buscarPorId(@PathVariable Long id) {
        var especialidade = service.listarPorId(id);

        return ResponseEntity.ok(especialidade);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDto> editar(@PathVariable Long id,
                                                           @RequestBody @Valid EspecialidadeRequestDto especialidadeRequestDto){
        var especialidade = service.alterar(id, especialidadeRequestDto);

        return ResponseEntity.ok(especialidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
       service.excluir(id);

       return ResponseEntity.noContent().build();
    }

}
