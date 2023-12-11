package com.stc.system.application.port.in;

import static com.stc.system.common.validation.Validation.validate;

import jakarta.validation.constraints.NotNull;

public interface AddSpaceUseCase {
    void addSpace(AddSpaceCommand command);

    public static record AddSpaceCommand(
            @NotNull String permissionGroupName,
            @NotNull String spaceName) {

        public AddSpaceCommand(String permissionGroupName, String spaceName) {
            this.permissionGroupName = permissionGroupName;
            this.spaceName = spaceName;
            validate(this);
        }
    }
}
