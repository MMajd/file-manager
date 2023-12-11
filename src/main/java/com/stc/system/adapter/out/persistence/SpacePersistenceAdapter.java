package com.stc.system.adapter.out.persistence;

import java.util.List;

import com.stc.system.adapter.out.persistence.entity.SpaceJpaEntity;
import com.stc.system.adapter.out.persistence.mapper.SpaceMapper;
import com.stc.system.adapter.out.persistence.repository.SpaceJpaRepository;
import com.stc.system.application.domain.model.Space;
import com.stc.system.application.port.out.AddSpacePort;
import com.stc.system.application.port.out.LoadSpacePort;
import com.stc.system.common.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SpacePersistenceAdapter implements AddSpacePort, LoadSpacePort {
    private final SpaceMapper spaceMapper;
    private final SpaceJpaRepository spaceJpaRepository;

    @Override
    public Space loadSpace(String name) {
        List<SpaceJpaEntity> spaceJpaEntities = spaceJpaRepository.findByName(name);
        if (spaceJpaEntities.isEmpty()) {
            throw new RuntimeException("Space not found");
        }
        return spaceMapper.fromEntityToDomain(spaceJpaEntities.get(0));
    }

    @Override
    public void addSpace(Space space) {
        spaceJpaRepository.save(spaceMapper.fromDomainToEntity(space));
    }

}
