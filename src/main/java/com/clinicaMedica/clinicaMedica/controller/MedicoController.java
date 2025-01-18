package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.model.medico.MedicoRequestDto;
import com.clinicaMedica.clinicaMedica.model.medico.MedicoResponseDto;
import com.clinicaMedica.clinicaMedica.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medico")

public class MedicoController {

    @Autowired
    private MedicoService service;


    @PostMapping
    public ResponseEntity<MedicoResponseDto> cadastrar(@RequestBody @Valid MedicoRequestDto dto,
                                                       UriComponentsBuilder uriBuilder) {
        var medico = service.cadastrar(dto);
        var uri = uriBuilder.path("/medico/{id}")
                .buildAndExpand(medico.id())
                .toUri();

        return ResponseEntity.created(uri).body(medico);
    }


    @GetMapping
    public ResponseEntity<Page<MedicoResponseDto>> listar(Pageable pageable) {
        var medicos = service.listar(pageable);

        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDto> listarPorId(@PathVariable Long id) {
        var medico = service.listarPorId(id);

        return ResponseEntity.ok(medico);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDto> alterar(@RequestBody @Valid MedicoRequestDto medicoRequestDto,
                                                     @PathVariable Long id) {
        var medico = service.alterar(id, medicoRequestDto);

        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
