package com.stc.system.application.domain.service;

import com.stc.system.application.domain.model.Folder;
import com.stc.system.application.domain.model.User;
import com.stc.system.application.exception.OperationNotAllowedException;
import com.stc.system.application.port.in.AddFolderUseCase;
import com.stc.system.application.port.out.AddFolderPort;
import com.stc.system.application.port.out.LoadUserPort;
import com.stc.system.application.value.Permission;
import com.stc.system.common.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class AddFolderService implements AddFolderUseCase {
    private final LoadUserPort loadUserPort;
    private final AddFolderPort addFolderPort;

    @Override
    public void addFolder(AddFolderCommand command) {
        User user = loadUserPort.loadUser(command.username());

        user.getPermissions().stream()
                .filter(p -> p.equals(Permission.EDIT))
                .findFirst()
                .orElseThrow(OperationNotAllowedException::new);

        addFolderPort.addFolder(Folder.builder()
                .name(command.folderName())
                .owner(user).build());
    }
}
