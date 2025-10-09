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
    public ResponseEntity<Void> salvarPadaria(@RequestBody Padaria padaria) {
        padariaService.salvarPadaria(padaria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
        @GetMapping("/{id}")
        public ResponseEntity<Padaria> buscarPorId (@PathVariable Long id){
            Padaria padaria = padariaService.buscarPorId(id);
            return ResponseEntity.ok(padaria);

        }

        @GetMapping
        public ResponseEntity<List<Padaria>> listarTodos () { return ResponseEntity.ok(padariaService.listarTodos());

        }
        @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPadaria(@PathVariable Long id, @RequestBody Padaria padaria) {
        padariaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
        }
    }
