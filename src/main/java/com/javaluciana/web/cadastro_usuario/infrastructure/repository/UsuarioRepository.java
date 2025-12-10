package com.javaluciana.web.cadastro_usuario.infrastructure.repository;

import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

  Optional<Usuario> findByCpf(String cpf);

  @Transactional
  void deleteByCpf(String cpf);
}

