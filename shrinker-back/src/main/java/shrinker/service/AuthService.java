package shrinker.service;

import shrinker.domain.Usuario;
import shrinker.repository.UsuarioRepository;
import shrinker.security.AuthUser;
import shrinker.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private Random rand = new Random();

    public static AuthUser authenticated() {
        try {
            return (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }


    public String sendNewPassword(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new ObjectNotFoundException("Email não encontrado!");
        }

        String newPass = newPassword();
        usuario.setSenha(passwordEncoder.encode(newPass));
        usuarioRepository.save(usuario);
        return newPass;
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) {
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) {
            return (char) (rand.nextInt(26) + 65);
        } else {
            return (char) (rand.nextInt(26) + 97);
        }
    }
}
