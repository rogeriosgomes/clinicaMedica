package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.model.Paciente.PacienteRequestDto;
import com.clinicaMedica.clinicaMedica.model.Paciente.PacienteResponseDto;
import com.clinicaMedica.clinicaMedica.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {


    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDto> cadastrar(@RequestBody @Valid PacienteRequestDto dto,
                                                         UriComponentsBuilder uriBuilder){

        var paciente = pacienteService.cadastrar(dto);
        var uri = uriBuilder.path("/paciente/{id}")
                .buildAndExpand(paciente.id()).toUri();

        return ResponseEntity.created(uri).body(paciente);
    }

    @GetMapping
    public ResponseEntity<Page<PacienteResponseDto>> listarTodos(Pageable pageable){

        var pacientes = pacienteService.listarTodos(pageable);

        return ResponseEntity.ok(pacientes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> listarPorId(@PathVariable Long id){
        var paciente = pacienteService.listarPorId(id);

        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> alterar(@PathVariable Long id,
                                                       @RequestBody @Valid PacienteRequestDto dto){
        var paciente = pacienteService.alterar(id, dto);

        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        pacienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
