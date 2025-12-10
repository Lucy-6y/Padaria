package com.javaluciana.web.cadastro_usuario.infrastructure.entitys;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "padaria")
public class Padaria {

    @Id
    private Long id;


    private String nome;


    private Double preco;


    private Integer quantidade;
}
