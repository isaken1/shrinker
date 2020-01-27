package com.isaackennedy.shrinker.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class GenericDomainUnit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    protected Long id;

    public GenericDomainUnit() {}

    public GenericDomainUnit(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericDomainUnit other = (GenericDomainUnit) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
