package com.clinicaMedica.clinicaMedica.controller;

import com.clinicaMedica.clinicaMedica.infra.Security.TokenService;
import com.clinicaMedica.clinicaMedica.infra.Security.tokenJWTDto;
import com.clinicaMedica.clinicaMedica.model.usuario.Usuario;
import com.clinicaMedica.clinicaMedica.service.AutenticacaoService;
import com.clinicaMedica.clinicaMedica.usuario.UsuarioRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid UsuarioRequestDto dto) {

        var authenticationToken  = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new tokenJWTDto(tokenJWT));
    }
}
