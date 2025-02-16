package shrinker.service;

import shrinker.domain.URL;
import shrinker.domain.Usuario;
import shrinker.dto.NewUrlDTO;
import shrinker.dto.UrlDTO;
import shrinker.repository.URLRepository;
import shrinker.security.AuthUser;
import shrinker.service.exception.AuthorizationException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class URLService extends GenericService<URL> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private final Base64 encoder = new Base64(true);

    @Autowired
    private URLRepository urlRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public URLService(JpaRepository<URL, Long> repository) {
        super(repository);
    }

    @Override
    void updateData(URL newObj, URL obj) {
        newObj.setUrlEncurtada(shrinkUrl(obj.getUrlOriginal()));
    }

    @Override
    public URL insert(URL obj) {
        AuthUser user = AuthService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }

        Usuario usuario = usuarioService.find(user.getId());

        Optional<URL> url = urlRepository.findByUrlOriginalAndUsuario(obj.getUrlOriginal(), usuario);
        if (url.isPresent()) {
            if (url.get().getUrlOriginal().equals(obj.getUrlOriginal())) {

            }
            return update(obj);
        } else {
            return urlRepository.save(obj);
        }
    }

    public List<URL> findAllFromUser() {
        AuthUser user = AuthService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }

        Usuario usuario = usuarioService.find(user.getId());
        return urlRepository.findByUsuario(usuario);
    }

    private String shrinkUrl(String urlOriginal) {
        return "shrn.kd/" + encoder.encodeAsString(urlOriginal.getBytes(StandardCharsets.UTF_8));
    }

    public URL fromDTO(NewUrlDTO objDTO) {
        return new URL(null, new Date(),
                usuarioService.find(AuthService.authenticated().getId()), objDTO.getUrlOriginal(),
                shrinkUrl(objDTO.getUrlOriginal()));
    }

    public URL fromDTO(UrlDTO objDTO) {
        return new URL(null , objDTO.getDtCriacao(),
                usuarioService.find(AuthService.authenticated().getId()), objDTO.getUrlOriginal(),
                objDTO.getUrlEncurtada());
    }
}
