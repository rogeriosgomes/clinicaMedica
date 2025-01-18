package com.clinicaMedica.clinicaMedica.service;

import com.clinicaMedica.clinicaMedica.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

}
