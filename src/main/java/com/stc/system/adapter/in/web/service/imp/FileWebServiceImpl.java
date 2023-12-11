package com.stc.system.adapter.in.web.service.imp;

import com.stc.system.adapter.in.web.dto.AddFileDto;
import com.stc.system.adapter.in.web.service.AddFileWebService;
import com.stc.system.application.port.in.AddFileUseCase;
import com.stc.system.application.port.in.AddFileUseCase.AddFileCommand;
import com.stc.system.common.WebService;

import lombok.RequiredArgsConstructor;

@WebService
@RequiredArgsConstructor
public class FileWebServiceImpl implements AddFileWebService {
    private final AddFileUseCase addFileService;

    @Override
    public void addFile(AddFileDto addFileDto) {
        addFileService.addFile(
                new AddFileCommand(
                        addFileDto.username(), addFileDto.folderName(), addFileDto.filename(),
                        addFileDto.mimeType(), addFileDto.data()));
    }

}
