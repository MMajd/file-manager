package com.stc.system.adapter.in.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stc.system.adapter.in.web.dto.AddSpaceDto;
import com.stc.system.adapter.in.web.service.AddSpaceWebService;
import com.stc.system.common.WebAdapter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class SpaceController {
    private final AddSpaceWebService addSpaceWebService;

    @PostMapping("/space")
    ResponseEntity<Object> addSpace(@RequestBody @Valid AddSpaceDto addSpaceDto) {
        addSpaceWebService.addSpace(addSpaceDto);
        return ResponseEntity.ok().build();
    }

}
