package com.stc.system.application.domain.model;

import java.util.Optional;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class File {
    private FileId id;

    @Getter
    @NonNull
    private final String name;

    @Getter
    @NonNull
    private final byte[] data;

    @Getter
    @NonNull
    private final String dataUrl;

    @Getter
    @NonNull
    private final Folder folder;

    @Getter
    @NonNull
    private final String mimeType;

    public Optional<FileId> getId() {
        return Optional.ofNullable(this.id);
    }

    @Value
    public final static class FileId {
        private final long value;
    }
}
