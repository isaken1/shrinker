package shrinker.config;

import shrinker.domain.Usuario;
import shrinker.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public boolean instantiateTestDB() {
        Usuario user = new Usuario(null, "isaac_kennedy@hotmail.com", "Isaac Kennedy",
                passwordEncoder.encode("abcd1234"));
        usuarioService.insert(user);
        return true;
    }
}
