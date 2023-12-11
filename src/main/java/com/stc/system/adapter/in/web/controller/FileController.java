package com.stc.system.adapter.in.web.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stc.system.adapter.in.web.dto.AddFileDto;
import com.stc.system.adapter.in.web.service.AddFileWebService;
import com.stc.system.common.WebAdapter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FileController {
    private final AddFileWebService addFileWebService;

    @PostMapping("/file")
    ResponseEntity<Object> addFile(
            @NotBlank @RequestParam("username") String username,
            @NotBlank @RequestParam("folder") String folder,
            @NotNull @RequestParam("file") MultipartFile file) throws IOException {

        final String filename = StringUtils.cleanPath(file.getOriginalFilename());
        final String mimeType = file.getContentType();
        final byte[] data = file.getBytes();

        AddFileDto addFileDto = new AddFileDto(username, folder, filename, mimeType, data);
        addFileWebService.addFile(addFileDto);
        return ResponseEntity.ok().build();
    }
}
