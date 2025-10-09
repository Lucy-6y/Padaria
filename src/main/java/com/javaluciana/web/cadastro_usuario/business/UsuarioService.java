package com.javaluciana.web.cadastro_usuario.business;

import com.javaluciana.web.cadastro_usuario.infrastructure.entitys.Usuario;
import com.javaluciana.web.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {

        this.repository = repository;
    }

    public void SalvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }
    public Usuario buscarUsuarioPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("CPF nao encontrado"));

}
public void deletarUsuarioPorCpf(String cpf) {
    repository.deleteByCpf(cpf);
    }
    public void atualizarUsuarioPorCpf(String cpf,  Usuario usuario) {

        Usuario usuarioEntity = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        if(usuario.getNome() !=null) {
            usuarioEntity.setNome(usuario.getNome());
        }
        if(usuario.getEmail() !=null) {
            usuarioEntity.setEmail(usuario.getEmail());
        }
        if(usuario.getTelefone() !=null) {
            usuarioEntity.setTelefone(usuario.getTelefone());
        }
        if(usuario.getDataNascimento() !=null) {
            usuarioEntity.setDataNascimento(usuario.getDataNascimento());
        }
        repository.save(usuarioEntity);
    }
   public List<Usuario> listarTodos() { return repository.findAll();
    }
}