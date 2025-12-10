package com.javaluciana.web.cadastro_usuario.infrastructure.repository;

import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Padaria;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PadariaRepository extends MongoRepository<Padaria, Long> {

}
