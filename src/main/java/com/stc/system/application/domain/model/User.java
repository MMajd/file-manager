package com.stc.system.application.domain.model;

import java.util.Optional;
import java.util.Set;

import com.stc.system.application.value.Permission;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class User {
    private UserId id;

    @Getter
    @NonNull
    private final String username;

    @Getter
    @NonNull
    private final PermissionGroup permissionGroup;

    @Getter
    @NonNull
    private final Set<Permission> permissions;

    public Optional<UserId> getId() {
        return Optional.ofNullable(this.id);
    }

    @Value
    public static final class UserId {
        private final Long value;
    }
}
