package com.javaluciana.web.cadastro_usuario.infrastructure.entitys;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "compra")
public class Compra {
    @Id
    private Long id;

    @DBRef
    private Usuario usuario;


    private List<Padaria> produtos;


    private LocalDateTime dataCompra;


    private Double valorTotal;
}
