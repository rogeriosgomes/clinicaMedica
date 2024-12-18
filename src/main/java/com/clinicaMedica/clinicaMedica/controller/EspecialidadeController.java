package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.domain.especialidade.EspecialidadeRequestDto;
import com.clinicaMedica.clinicaMedica.domain.especialidade.EspecialidadeResponseDto;
import com.clinicaMedica.clinicaMedica.service.EspecialidadeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {

    @Autowired
    private  EspecialidadeService service;


    @PostMapping
    private ResponseEntity<EspecialidadeResponseDto> cadastrar(@RequestBody  EspecialidadeRequestDto especialidadeRequestDto){
        var especialidade = service.cadastrar(especialidadeRequestDto);

        return ResponseEntity.ok(especialidade);
    }

    @Transactional
    @GetMapping
    public ResponseEntity<Page<EspecialidadeResponseDto>> listarTodos(Pageable pageable){
        var especialidades = service.listarTodos(pageable);

        return ResponseEntity.ok(especialidades);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDto> buscarPorId(@PathVariable Long id) {
        var especialidade = service.listarPorId(id);

        return ResponseEntity.ok(especialidade);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDto> editar(@PathVariable Long id,
                                                           @RequestBody EspecialidadeRequestDto especialidadeRequestDto){
        var especialidade = service.alterar(id, especialidadeRequestDto);

        return ResponseEntity.ok(especialidade);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
       service.excluir(id);

       return ResponseEntity.noContent().build();
    }

}
