package com.stc.system.application.domain.service;

import com.stc.system.application.domain.model.PermissionGroup;
import com.stc.system.application.domain.model.Space;
import com.stc.system.application.port.in.AddSpaceUseCase;
import com.stc.system.application.port.out.AddSpacePort;
import com.stc.system.application.port.out.LoadPermissionGroupPort;
import com.stc.system.common.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class AddSpaceService implements AddSpaceUseCase {
    private final AddSpacePort addSpacePort;
    private final LoadPermissionGroupPort loadPermissionGroupPort;

    @Override
    public void addSpace(AddSpaceCommand command) {
        PermissionGroup permissionGroup = loadPermissionGroupPort
                .loadPermissionGroup(command.permissionGroupName());

        addSpacePort.addSpace(Space.builder()
                .name(command.spaceName())
                .permissionGroup(permissionGroup)
                .build());
    }
}
