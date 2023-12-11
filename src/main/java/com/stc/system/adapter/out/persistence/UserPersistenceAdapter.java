package com.stc.system.adapter.out.persistence;

import java.util.Objects;

import com.stc.system.adapter.out.persistence.entity.UserJpaEntity;
import com.stc.system.adapter.out.persistence.mapper.UserMapper;
import com.stc.system.adapter.out.persistence.repository.UserJpaRepository;
import com.stc.system.application.domain.model.User;
import com.stc.system.application.port.out.LoadUserPort;
import com.stc.system.common.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements LoadUserPort {
    private final UserMapper userMapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public User loadUser(String username) {
        UserJpaEntity userJpaEntity = userJpaRepository.findByUsername(username);

        if (Objects.isNull(userJpaEntity)) {
            throw new RuntimeException("No user with specified 'username' = " + username);
        }

        return userMapper.fromEntityToDomain(userJpaEntity);
    }

}
