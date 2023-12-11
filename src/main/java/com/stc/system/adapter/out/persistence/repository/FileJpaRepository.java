package com.stc.system.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.system.adapter.out.persistence.entity.FileJpaEntity;
import com.stc.system.common.PersistenceAdapter;

@PersistenceAdapter
public interface FileJpaRepository extends JpaRepository<FileJpaEntity, Long> {
    List<FileJpaEntity> findByName(String filename);
}
