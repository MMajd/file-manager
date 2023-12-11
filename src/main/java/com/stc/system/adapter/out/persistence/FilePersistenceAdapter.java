package com.stc.system.adapter.out.persistence;

import java.util.List;

import com.stc.system.adapter.out.persistence.entity.FileJpaEntity;
import com.stc.system.adapter.out.persistence.mapper.FileMapper;
import com.stc.system.adapter.out.persistence.repository.FileJpaRepository;
import com.stc.system.application.domain.model.File;
import com.stc.system.application.port.out.AddFilePort;
import com.stc.system.application.port.out.LoadFilePort;
import com.stc.system.common.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FilePersistenceAdapter implements AddFilePort, LoadFilePort {
    private final FileJpaRepository fileJpaRepository;
    private final FileMapper fileMapper;

    @Override
    public File loadFile(String filename) {
        List<FileJpaEntity> fileJpaEntities = fileJpaRepository.findByName(filename);
        if (fileJpaEntities.isEmpty()) {
            throw new RuntimeException("File not found");
        }

        return fileMapper.fromEntityToDomain(fileJpaEntities.get(0));
    }

    @Override
    public void addFile(File file) {
        fileJpaRepository.save(fileMapper.fromDomainToEntity(file));
    }

}
