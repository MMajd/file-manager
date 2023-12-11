package com.stc.system.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record AddSpaceDto(@NotNull String permissionGroupName, @NotNull String spaceName) {
}
