package com.stc.system.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.system.adapter.out.persistence.entity.FolderJpaEntity;
import com.stc.system.common.PersistenceAdapter;

@PersistenceAdapter
public interface FolderJpaRepository extends JpaRepository<FolderJpaEntity, Long> {
    List<FolderJpaEntity> findByName(String name);
}
