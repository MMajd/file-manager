package com.stc;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stc.system.adapter.out.persistence.entity.PermissionGroupJpaEntity;
import com.stc.system.adapter.out.persistence.repository.PermissionGroupJpaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class StcAssessmentApplication implements CommandLineRunner {
    @Autowired
    PermissionGroupJpaRepository permissionGroupJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(StcAssessmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        permissionGroupJpaRepository
                .save(PermissionGroupJpaEntity.builder().name("Admin").build());

        String groups = permissionGroupJpaRepository
                .findAll()
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.joining(","));

        log.info("Avaliable Permission Groups:\t{}", groups);
    }
}
