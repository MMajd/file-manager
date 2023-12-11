package com.stc.system.application.port.out;

import com.stc.system.application.domain.model.File;

public interface LoadFilePort {
    File loadFile(String filename);
}
