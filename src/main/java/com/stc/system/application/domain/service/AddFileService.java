package com.stc.system.application.domain.service;

import com.stc.system.application.domain.model.File;
import com.stc.system.application.domain.model.Folder;
import com.stc.system.application.domain.model.User;
import com.stc.system.application.exception.OperationNotAllowedException;
import com.stc.system.application.port.in.AddFileUseCase;
import com.stc.system.application.port.out.AddFilePort;
import com.stc.system.application.port.out.LoadFolderPort;
import com.stc.system.application.port.out.LoadUserPort;
import com.stc.system.common.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class AddFileService implements AddFileUseCase {
    private final AddFilePort addFilePort;
    private final LoadUserPort loadUserPort;
    private final LoadFolderPort loadFolderPort;

    @Override
    public void addFile(AddFileCommand command) {
        User user = loadUserPort.loadUser(command.username());
        Folder folder = loadFolderPort.loadFolder(command.folderName());

        if (!folder.getOwner().equals(user)) {
            throw new OperationNotAllowedException();
        }

        addFilePort.addFile(File.builder()
                .name(command.fileName())
                .data(command.data())
                .folder(folder)
                .dataUrl(folder.getName() + "/" + command.fileName())
                .build());
    }
}
