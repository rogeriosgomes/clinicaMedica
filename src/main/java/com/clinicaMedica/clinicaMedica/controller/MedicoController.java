package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.domain.medico.MedicoRequestDto;
import com.clinicaMedica.clinicaMedica.domain.medico.MedicoResponseDto;
import com.clinicaMedica.clinicaMedica.service.MedicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")

public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    public ResponseEntity<MedicoResponseDto> cadastrar(@RequestBody @Validated MedicoRequestDto medicoRequestDto) {
        var medico = service.cadastrar(medicoRequestDto);

        return ResponseEntity.ok(medico);
    }

    @Transactional
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

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDto> alterar(@RequestBody @Validated MedicoRequestDto medicoRequestDto,
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
