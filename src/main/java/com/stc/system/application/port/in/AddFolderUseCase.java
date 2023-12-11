package com.stc.system.application.port.in;

import static com.stc.system.common.validation.Validation.validate;

import jakarta.validation.constraints.NotNull;

public interface AddFolderUseCase {
    void addFolder(AddFolderCommand command);

    public static final record AddFolderCommand(@NotNull String username, @NotNull String folderName) {
        public AddFolderCommand(String username, String folderName) {
            this.username = username;
            this.folderName = folderName;
            validate(this);
        }
    }
}
