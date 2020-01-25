package com.isaackennedy.shrinker.repository;

import com.isaackennedy.shrinker.domain.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {}
