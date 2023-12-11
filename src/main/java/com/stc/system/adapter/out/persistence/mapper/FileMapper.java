package com.stc.system.adapter.out.persistence.mapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.stc.system.adapter.out.persistence.entity.FileJpaEntity;
import com.stc.system.adapter.out.persistence.entity.FolderJpaEntity;
import com.stc.system.application.domain.model.File;
import com.stc.system.application.domain.model.Folder;
import com.stc.system.application.domain.model.File.FileId;
import com.stc.system.common.WebService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

@WebService
@RequiredArgsConstructor
public class FileMapper implements Mapper<File, FileJpaEntity> {
    private final FolderMapper folderMapper;

    @Override
    public File fromEntityToDomain(FileJpaEntity entity) {
        Folder folder = folderMapper.fromEntityToDomain(entity.getFolder());

        return File
                .builder()
                .name(entity.getName())
                .data(FileUtils.loadData(entity.getDataUrl()))
                .folder(folder)
                .mimeType(entity.getMimeType())
                .build();
    }

    @Override
    public FileJpaEntity fromDomainToEntity(File domain) {
        Long id = domain.getId().map(FileId::getValue).orElse(null);
        FolderJpaEntity folderJpaEntity = folderMapper.fromDomainToEntity(domain.getFolder());

        FileUtils.save(domain.getDataUrl(), domain.getData());

        return FileJpaEntity
                .builder()
                .id(id)
                .name(domain.getName())
                .mimeType(domain.getMimeType())
                .dataUrl(domain.getDataUrl())
                .folder(folderJpaEntity)
                .build();
    }

    @UtilityClass
    private class FileUtils {
        private static final Path root = Paths.get("uploads");

        public String save(String filename, byte[] data) {
            try {
                Files.copy(new ByteArrayInputStream(data), root.resolve(filename));
                return root.resolve(filename).toString();
            } catch (Exception e) {
                if (e instanceof FileAlreadyExistsException) {
                    throw new RuntimeException("this file already exists before");
                }
                throw new RuntimeException(e.getMessage());
            }
        }

        public static byte[] loadData(String filename) {
            try {
                Path file = root.resolve(filename);
                Resource resource = new UrlResource(file.toUri());
                if (resource.exists() || resource.isReadable()) {
                    return resource.getContentAsByteArray();
                } else {
                    throw new RuntimeException("Could not read the file!");
                }
            } catch (IOException e) {
                throw new RuntimeException("Error: " + e.getMessage());
            }
        }

    }
}
