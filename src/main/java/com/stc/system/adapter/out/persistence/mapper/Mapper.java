package com.stc.system.adapter.out.persistence.mapper;

public interface Mapper<D, E> {
    D fromEntityToDomain(E entity);

    E fromDomainToEntity(D domain);
}