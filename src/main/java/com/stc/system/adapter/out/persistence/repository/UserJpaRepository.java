package com.stc.system.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.system.adapter.out.persistence.entity.UserJpaEntity;
import com.stc.system.common.PersistenceAdapter;

@PersistenceAdapter
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
    UserJpaEntity findByUsername(String username);
}
