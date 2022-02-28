package com.volkruss.misaka.web.repository.user;

import com.volkruss.misaka.domain.dao.user.UserJpa;
import com.volkruss.misaka.domain.model.user.User;
import com.volkruss.misaka.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserJpa userJpa;

    @Override
    public User findByUserName(String username) {
        return userJpa.findById(username).orElseThrow( () -> new UsernameNotFoundException("not found"));
    }
}
