package com.isaackennedy.shrinker.service;

import com.isaackennedy.shrinker.domain.GenericDomainUnit;
import com.isaackennedy.shrinker.service.exception.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class GenericService<T extends GenericDomainUnit> {

    protected JpaRepository<T, Long> repo;

    public GenericService(JpaRepository<T, Long> repository) {
        this.repo = repository;
    }

    public T find(Long id) {
        Optional<T> obj = repo.findById(id);

        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + obj.getClass().getName()));
    }

    public T insert(T obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public boolean exists(Long id) {
        return repo.existsById(id);
    }

    public T update(T obj) {
        T newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(obj);
    }

    public long count() { return repo.count(); }

    public List<T> findAll() { return repo.findAll(); }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    abstract void updateData(T newObj, T oldObj);
}
