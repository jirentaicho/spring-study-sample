package com.volkruss.misaka.domain.repository.user;

import com.volkruss.misaka.domain.model.user.User;

public interface UserRepository {
    User findByUserName(String username);
}
