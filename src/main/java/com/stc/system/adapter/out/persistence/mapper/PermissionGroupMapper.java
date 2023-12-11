package com.stc.system.adapter.out.persistence.mapper;

import com.stc.system.adapter.out.persistence.entity.PermissionGroupJpaEntity;
import com.stc.system.application.domain.model.PermissionGroup;
import com.stc.system.application.domain.model.PermissionGroup.PermissionGroupId;
import com.stc.system.common.WebService;

@WebService
public class PermissionGroupMapper implements Mapper<PermissionGroup, PermissionGroupJpaEntity> {

    @Override
    public PermissionGroup fromEntityToDomain(PermissionGroupJpaEntity entity) {
        return PermissionGroup
                .builder()
                .id(new PermissionGroupId(entity.getId()))
                .name(entity.getName())
                .build();
    }

    @Override
    public PermissionGroupJpaEntity fromDomainToEntity(PermissionGroup domain) {
        Long id = domain.getId().map(PermissionGroupId::getValue).orElseGet(null);

        return PermissionGroupJpaEntity
                .builder()
                .id(id)
                .name(domain.getName())
                .build();
    }
}
