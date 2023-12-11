package com.stc.system.application.port.out;

import com.stc.system.application.domain.model.User;

public interface LoadUserPort {
    User loadUser(String username);
}
