package com.isaackennedy.shrinker.service;

import com.isaackennedy.shrinker.domain.Usuario;
import com.isaackennedy.shrinker.repository.UsuarioRepository;
import com.isaackennedy.shrinker.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario find(Long id) {
        Optional<Usuario> user = usuarioRepository.findById(id);

        return user.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Usuario.class.getName()));
    }

    public Usuario insert(Usuario obj) {
        obj.setId(null);
        return usuarioRepository.save(obj);
    }

}
