package com.stc.system.application.port.in;

import static com.stc.system.common.validation.Validation.validate;

import jakarta.validation.constraints.NotNull;

public interface AddFileUseCase {
    void addFile(AddFileCommand command);

    public static final record AddFileCommand(
            @NotNull String username,
            @NotNull String folderName,
            @NotNull String fileName,
            @NotNull String mimeType,
            @NotNull byte[] data) {

        public AddFileCommand(
                String username, String folderName, String fileName, String mimeType, byte[] data) {
            this.username = username;
            this.folderName = folderName;
            this.fileName = fileName;
            this.data = data;
            this.mimeType = mimeType;
            validate(this);
        }
    }
}
