package com.javaluciana.web.cadastro_usuario.controller;

import com.javaluciana.web.cadastro_usuario.business.CompraService;
import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Compra;
import dto.CompraRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraRequestDTO dto) {
        Compra novaCompra = compraService.criarCompraComDTO(dto);
        return  ResponseEntity.ok(novaCompra);
    }
}
