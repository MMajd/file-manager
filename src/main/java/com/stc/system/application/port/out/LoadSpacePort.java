package com.stc.system.application.port.out;

import com.stc.system.application.domain.model.Space;

public interface LoadSpacePort {
    Space loadSpace(String name);
}
