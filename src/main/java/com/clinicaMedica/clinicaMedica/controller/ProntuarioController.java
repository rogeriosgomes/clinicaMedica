package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.model.Prontuario.ProntuarioRequestDto;
import com.clinicaMedica.clinicaMedica.model.Prontuario.ProntuarioResponseDto;
import com.clinicaMedica.clinicaMedica.service.ProntuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/prontuario")
@RequiredArgsConstructor
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<ProntuarioResponseDto> cadastrar(@RequestBody @Valid ProntuarioRequestDto dto,
                                                           UriComponentsBuilder uriBuilder){
        var prontuario = prontuarioService.cadastrar(dto);
        var uri = uriBuilder.path("/prontuario/{id}").buildAndExpand(prontuario.id()).toUri();

        return ResponseEntity.created(uri).body(prontuario);
    }

    @GetMapping
    public ResponseEntity<Page<ProntuarioResponseDto>> listarTodos(Pageable pageable){
        var pacientes = prontuarioService.listarTodos(pageable);

        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDto> listarPorId(@PathVariable  Long id){
        var prontuario = prontuarioService.listarPorId(id);

        return  ResponseEntity.ok(prontuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDto> alterar(@PathVariable Long id,
                                                         @RequestBody @Valid ProntuarioRequestDto dto ){
        var paciente = prontuarioService.alterar(id, dto);

        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        prontuarioService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
