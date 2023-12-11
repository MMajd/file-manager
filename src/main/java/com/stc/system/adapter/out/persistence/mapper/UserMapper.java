package com.stc.system.adapter.out.persistence.mapper;

import com.stc.system.adapter.out.persistence.entity.PermissionGroupJpaEntity;
import com.stc.system.adapter.out.persistence.entity.UserJpaEntity;
import com.stc.system.application.domain.model.PermissionGroup;
import com.stc.system.application.domain.model.User;
import com.stc.system.application.domain.model.User.UserId;
import com.stc.system.common.WebService;

import lombok.RequiredArgsConstructor;

@WebService
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserJpaEntity> {
    private final PermissionGroupMapper permissionGroupMapper;

    @Override
    public User fromEntityToDomain(UserJpaEntity entity) {
        PermissionGroup permissionGroup = permissionGroupMapper
                .fromEntityToDomain(entity.getPermissionGroup());

        return User
                .builder()
                .id(new UserId(entity.getId()))
                .username(entity.getUsername())
                .permissionGroup(permissionGroup)
                .permissions(entity.getPermissions())
                .build();
    }

    @Override
    public UserJpaEntity fromDomainToEntity(User domain) {
        Long id = domain.getId().map(UserId::getValue).orElseGet(null);
        PermissionGroupJpaEntity permissionGroup = permissionGroupMapper
                .fromDomainToEntity(domain.getPermissionGroup());

        return UserJpaEntity
                .builder()
                .id(id)
                .username(domain.getUsername())
                .permissionGroup(permissionGroup)
                .permissions(domain.getPermissions())
                .build();
    }
}
