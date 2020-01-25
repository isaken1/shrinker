package com.isaackennedy.shrinker.service;

import com.isaackennedy.shrinker.domain.GenericDomainUnit;
import com.isaackennedy.shrinker.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class GenericService<T extends GenericDomainUnit, R extends JpaRepository<T, Long>> {

    @Autowired
    protected R repo;

    public T find(Long id) {
        Optional<T> obj = repo.findById(id);

        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + obj.getClass().getName()));
    }

    public T insert(T obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public T update(T obj) {
        T newObj = find(obj.getId());
    }
}
