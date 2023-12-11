package com.stc.system.adapter.out.persistence.mapper;

import com.stc.system.adapter.out.persistence.entity.FolderJpaEntity;
import com.stc.system.adapter.out.persistence.entity.SpaceJpaEntity;
import com.stc.system.adapter.out.persistence.entity.UserJpaEntity;
import com.stc.system.application.domain.model.Folder;
import com.stc.system.application.domain.model.Space;
import com.stc.system.application.domain.model.User;
import com.stc.system.application.domain.model.Folder.FolderId;
import com.stc.system.common.WebService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@WebService
@RequiredArgsConstructor
@Transactional
public class FolderMapper implements Mapper<Folder, FolderJpaEntity> {
    private final UserMapper userMapper;
    private final SpaceMapper spaceMapper;

    @Override
    public Folder fromEntityToDomain(FolderJpaEntity entity) {
        User user = userMapper.fromEntityToDomain(entity.getUser());
        Space space = spaceMapper.fromEntityToDomain(entity.getSpace());

        return Folder
                .builder()
                .id(new FolderId(entity.getId()))
                .name(entity.getName())
                .owner(user)
                .space(space)
                .build();
    }

    @Override
    public FolderJpaEntity fromDomainToEntity(Folder domain) {
        Long folderId = domain.getId().map(FolderId::getValue).orElse(null);
        UserJpaEntity userJpaEntity = userMapper.fromDomainToEntity(domain.getOwner());
        SpaceJpaEntity spaceJpaEntity = spaceMapper.fromDomainToEntity(domain.getSpace());

        return FolderJpaEntity
                .builder()
                .id(folderId)
                .name(domain.getName())
                .user(userJpaEntity)
                .space(spaceJpaEntity)
                .build();
    }
}
