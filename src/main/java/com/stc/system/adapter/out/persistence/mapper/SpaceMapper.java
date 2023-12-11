package com.stc.system.adapter.out.persistence.mapper;

import com.stc.system.adapter.out.persistence.entity.PermissionGroupJpaEntity;
import com.stc.system.adapter.out.persistence.entity.SpaceJpaEntity;
import com.stc.system.application.domain.model.PermissionGroup;
import com.stc.system.application.domain.model.Space;
import com.stc.system.application.domain.model.Space.SpaceId;
import com.stc.system.common.WebService;

import lombok.RequiredArgsConstructor;

@WebService
@RequiredArgsConstructor
public class SpaceMapper implements Mapper<Space, SpaceJpaEntity> {
    private final PermissionGroupMapper permissionGroupMapper;

    @Override
    public Space fromEntityToDomain(SpaceJpaEntity entity) {
        PermissionGroup permissionGroup = permissionGroupMapper
                .fromEntityToDomain(entity.getPermissionGroup());

        return Space.builder()
                .id(new SpaceId(entity.getId()))
                .name(entity.getName())
                .permissionGroup(permissionGroup)
                .build();
    }

    @Override
    public SpaceJpaEntity fromDomainToEntity(Space domain) {
        Long id = domain.getId().map(SpaceId::getValue).orElse(null);
        PermissionGroupJpaEntity permissionGroupJpaEntity = permissionGroupMapper
                .fromDomainToEntity(domain.getPermissionGroup());

        return SpaceJpaEntity.builder()
                .id(id)
                .name(domain.getName())
                .permissionGroup(permissionGroupJpaEntity)
                .build();
    }
}
