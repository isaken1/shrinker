package shrinker.service;

import shrinker.domain.Usuario;
import shrinker.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<Usuario> {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(JpaRepository<Usuario, Long> repository) {
        super(repository);
    }

    @Override
    public Usuario insert(Usuario obj) {
        return super.insert(obj);
    }


    @Override
    void updateData(Usuario newObj, Usuario obj) {
        newObj.setSenha(obj.getSenha());
    }

    public Usuario fromDTO(UsuarioDTO objDTO) {
        return new Usuario(null, objDTO.getEmail(), objDTO.getNome(), passwordEncoder.encode(objDTO.getSenha()));
    }

}
