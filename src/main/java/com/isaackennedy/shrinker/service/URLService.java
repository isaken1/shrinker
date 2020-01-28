package com.isaackennedy.shrinker.service;

import com.isaackennedy.shrinker.domain.URL;
import com.isaackennedy.shrinker.dto.UrlDTO;
import com.isaackennedy.shrinker.repository.URLRepository;
import com.isaackennedy.shrinker.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

@Service
public class URLService extends GenericService<URL> {

    private final Base64 encoder = new Base64(true);

    @Autowired
    private URLRepository urlRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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
        Optional<URL> url = urlRepository.findByUrlOriginal(obj.getUrlOriginal());
        if (url.isPresent()) {
            return update(obj);
        } else {
            return urlRepository.save(obj);
        }
    }

    private String shrinkUrl(String urlOriginal) {
        return "shrn.kd/" + encoder.encodeAsString(urlOriginal.getBytes(StandardCharsets.UTF_8));
    }

    public URL fromDTO(UrlDTO objDTO) {
        return new URL(null, new Date(System.currentTimeMillis()),
                usuarioRepository.findById(AuthService.authenticated().getId()).get(), objDTO.getUrlOriginal(),
                objDTO.getUrlEncurtada());
    }
}
