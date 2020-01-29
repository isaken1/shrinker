package com.isaackennedy.shrinker.repository;

import com.isaackennedy.shrinker.domain.URL;
import com.isaackennedy.shrinker.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {

    @Transactional(readOnly = true)
    Optional<URL> findByUrlOriginal(String urlOriginal);

    @Transactional(readOnly = true)
    List<URL> findByUsuario(Usuario usuario);

}
