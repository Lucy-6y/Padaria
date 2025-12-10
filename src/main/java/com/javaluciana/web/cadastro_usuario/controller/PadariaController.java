package com.javaluciana.web.cadastro_usuario.controller;

import com.javaluciana.web.cadastro_usuario.business.PadariaService;
import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Padaria;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/padaria")
@RequiredArgsConstructor
public class PadariaController {

    private final PadariaService padariaService;

    @PostMapping
    public ResponseEntity<Padaria> salvarPadaria(@RequestBody Padaria padaria) {
        Padaria novaPadaria = padariaService.salvarPadaria(padaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPadaria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Padaria> buscarPorId(@PathVariable String id) {
        Padaria padaria = padariaService.buscarPorId(id);
        return ResponseEntity.ok(padaria);
    }

    @GetMapping
    public ResponseEntity<List<Padaria>> listarTodos() {
        return ResponseEntity.ok(padariaService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Padaria> atualizarPadaria(
            @PathVariable String id,
            @RequestBody Padaria padaria
    ) {
        Padaria padariaAtualizada = padariaService.atualizarPadaria(id, padaria);
        return ResponseEntity.ok(padariaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        padariaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
