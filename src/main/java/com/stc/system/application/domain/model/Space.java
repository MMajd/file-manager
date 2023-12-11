package com.stc.system.application.domain.model;

import java.util.Optional;

import io.micrometer.common.lang.NonNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Space {
    private SpaceId id;

    @Getter
    @NonNull
    private final String name;

    @Getter
    @NonNull
    private final PermissionGroup permissionGroup;

    public Optional<SpaceId> getId() {
        return Optional.ofNullable(this.id);
    }

    @Value
    public static final class SpaceId {
        private final long value;
    }
}
