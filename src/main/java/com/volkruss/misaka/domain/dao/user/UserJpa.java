package com.volkruss.misaka.domain.dao.user;

import com.volkruss.misaka.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User,String> {
}
