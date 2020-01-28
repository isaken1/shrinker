package com.isaackennedy.shrinker.service;

import com.isaackennedy.shrinker.domain.Usuario;
import com.isaackennedy.shrinker.repository.UsuarioRepository;
import com.isaackennedy.shrinker.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService extends GenericService<Usuario> {

    @Autowired
    public UsuarioService(JpaRepository<Usuario, Long> repository) {
        super(repository);
    }

    @Override
    void updateData(Usuario newObj, Usuario obj) {
        newObj.setSenha(obj.getSenha());
    }

}
