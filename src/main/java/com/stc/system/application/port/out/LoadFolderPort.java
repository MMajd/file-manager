package com.stc.system.application.port.out;

import com.stc.system.application.domain.model.Folder;

public interface LoadFolderPort {
    Folder loadFolder(String folderName);
}
