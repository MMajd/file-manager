package com.stc.system.application.domain.model;

import java.util.Optional;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class PermissionGroup {
    private PermissionGroupId id;

    @Getter
    @NonNull
    private final String name;

    @Getter
    private Set<User> users;

    public Optional<PermissionGroupId> getId() {
        return Optional.ofNullable(this.id);
    }

    @Value
    public static final class PermissionGroupId {
        private final long value;
    }
}
