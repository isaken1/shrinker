package com.isaackennedy.shrinker.service;

import com.isaackennedy.shrinker.domain.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class URLService extends GenericService<URL> {

    @Autowired
    public URLService(JpaRepository<URL, Long> repository) {
        super(repository);
    }

    @Override
    void updateData(URL newObj, URL oldObj) {
        //TODO: Implementar método
    }
}
