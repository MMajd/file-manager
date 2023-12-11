package com.stc.system.adapter.in.web.service.imp;

import com.stc.system.adapter.in.web.dto.AddFolderDto;
import com.stc.system.adapter.in.web.service.AddFolderWebService;
import com.stc.system.application.port.in.AddFolderUseCase;
import com.stc.system.common.WebService;
import com.stc.system.application.port.in.AddFolderUseCase.AddFolderCommand;

import lombok.RequiredArgsConstructor;

@WebService
@RequiredArgsConstructor
class FolderWebServiceImpl implements AddFolderWebService {
    private final AddFolderUseCase addFolderService;

    @Override
    public void addFolder(AddFolderDto folderDto) {
        addFolderService.addFolder(
                new AddFolderCommand(folderDto.username(), folderDto.folderName()));
    }

}
