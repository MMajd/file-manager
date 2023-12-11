package com.stc.system.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "file")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String mimeType;

    @Column
    private String dataUrl;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private FolderJpaEntity folder;
}
