package com.stc.system.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.system.adapter.out.persistence.entity.PermissionGroupJpaEntity;
import com.stc.system.common.PersistenceAdapter;

@PersistenceAdapter
public interface PermissionGroupJpaRepository extends JpaRepository<PermissionGroupJpaEntity, Long> {
    PermissionGroupJpaEntity findByName(String name);
}
