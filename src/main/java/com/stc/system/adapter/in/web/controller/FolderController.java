package com.stc.system.adapter.in.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stc.system.adapter.in.web.dto.AddFolderDto;
import com.stc.system.adapter.in.web.service.AddFolderWebService;
import com.stc.system.common.WebAdapter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController("/folder")
@RequiredArgsConstructor
class FolderController {
    private final AddFolderWebService addFolderWebService;

    @PostMapping("/folder")
    ResponseEntity<Object> addFolder(@RequestBody @Valid AddFolderDto folderDto) {
        addFolderWebService.addFolder(folderDto);

        return ResponseEntity.ok().build();
    }
}
