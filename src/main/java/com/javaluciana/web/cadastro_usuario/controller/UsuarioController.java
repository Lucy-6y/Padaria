package com.javaluciana.web.cadastro_usuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import com.javaluciana.web.cadastro_usuario.business.UsuarioService;
import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.SalvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@RequestParam String cpf){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorCpf(cpf));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorCpf(@RequestParam String cpf){
        usuarioService.deletarUsuarioPorCpf(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorCpf(@RequestParam String cpf,
                                                      @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorCpf(cpf, usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
}



