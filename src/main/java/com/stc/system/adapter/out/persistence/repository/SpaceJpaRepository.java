package com.stc.system.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.system.adapter.out.persistence.entity.SpaceJpaEntity;
import com.stc.system.common.PersistenceAdapter;

@PersistenceAdapter
public interface SpaceJpaRepository extends JpaRepository<SpaceJpaEntity, Long> {
    List<SpaceJpaEntity> findByName(String name);
}
