package com.stc.system.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record AddFolderDto(@NotNull String username, @NotNull String folderName) {

}
