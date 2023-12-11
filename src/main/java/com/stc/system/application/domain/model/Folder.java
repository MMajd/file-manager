package com.stc.system.application.domain.model;

import java.util.Optional;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Folder {
    @Setter
    private FolderId id;

    @Getter
    @NonNull
    private final String name;

    @Getter
    @NonNull
    private final Space space;

    @Getter
    @NonNull
    private final User owner;

    public Optional<FolderId> getId() {
        return Optional.ofNullable(this.id);
    }

    @Value
    public static final class FolderId {
        private final long value;
    }
}
