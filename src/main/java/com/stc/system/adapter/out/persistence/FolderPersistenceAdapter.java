package com.stc.system.adapter.out.persistence;

import java.util.List;

import com.stc.system.adapter.out.persistence.entity.FolderJpaEntity;
import com.stc.system.adapter.out.persistence.mapper.FolderMapper;
import com.stc.system.adapter.out.persistence.repository.FolderJpaRepository;
import com.stc.system.application.domain.model.Folder;
import com.stc.system.application.port.out.AddFolderPort;
import com.stc.system.application.port.out.LoadFolderPort;
import com.stc.system.common.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FolderPersistenceAdapter implements AddFolderPort, LoadFolderPort {
    private final FolderJpaRepository folderJpaRepository;
    private final FolderMapper folderMapper;

    @Override
    public Folder loadFolder(String folderName) {
        List<FolderJpaEntity> folderJpaEntities = folderJpaRepository.findByName(folderName);
        if (folderJpaEntities.isEmpty()) {
            throw new RuntimeException("No folder with given name");
        }

        return folderMapper.fromEntityToDomain(folderJpaEntities.get(0));
    }

    @Override
    public void addFolder(Folder folder) {
        FolderJpaEntity folderJpaEntity = folderMapper.fromDomainToEntity(folder);
        folderJpaRepository.save(folderJpaEntity);
    }
}
