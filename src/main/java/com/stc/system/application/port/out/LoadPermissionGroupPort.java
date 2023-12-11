package com.stc.system.application.port.out;

import com.stc.system.application.domain.model.PermissionGroup;

public interface LoadPermissionGroupPort {
    PermissionGroup loadPermissionGroup(String permissionGroupName);
}
