package com.stc.system.adapter.in.web.dto;

import static com.stc.system.common.validation.Validation.validate;

import jakarta.validation.constraints.NotNull;

public record AddFileDto(
        @NotNull String username, @NotNull String folderName,
        @NotNull String filename, @NotNull String mimeType, byte[] data) {

    public AddFileDto(String username, String folderName, String filename, String mimeType, byte[] data) {
        this.username = username;
        this.folderName = folderName;
        this.filename = filename;
        this.mimeType = mimeType;
        this.data = data;
        validate(this);
    }
}
