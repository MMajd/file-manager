package com.stc.system.adapter.out.persistence;

import com.stc.system.adapter.out.persistence.entity.PermissionGroupJpaEntity;
import com.stc.system.adapter.out.persistence.mapper.PermissionGroupMapper;
import com.stc.system.adapter.out.persistence.repository.PermissionGroupJpaRepository;
import com.stc.system.application.domain.model.PermissionGroup;
import com.stc.system.application.port.out.LoadPermissionGroupPort;
import com.stc.system.common.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class PermissionGroupPersistenceAdapter implements LoadPermissionGroupPort {
    private final PermissionGroupMapper permissionGroupMapper;
    private final PermissionGroupJpaRepository permissionGroupJpaRepository;

    @Override
    public PermissionGroup loadPermissionGroup(String permissionGroupName) {
        PermissionGroupJpaEntity permissionGroupJpaEntity = permissionGroupJpaRepository
                .findByName(permissionGroupName);

        return permissionGroupMapper.fromEntityToDomain(permissionGroupJpaEntity);
    }

}
