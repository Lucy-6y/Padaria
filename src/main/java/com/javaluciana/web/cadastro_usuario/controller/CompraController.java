package com.javaluciana.web.cadastro_usuario.controller;

import dto.CompraRequestDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.javaluciana.web.cadastro_usuario.business.CompraService;
import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Compra;
import com.javaluciana.web.cadastro_usuario.infrastructure.dto.CompraRequestDTO;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraRequestDTO dto) {
        Compra novaCompra = compraService.criarCompraComDTO(dto);
        return ResponseEntity.ok(novaCompra);
    }
}
