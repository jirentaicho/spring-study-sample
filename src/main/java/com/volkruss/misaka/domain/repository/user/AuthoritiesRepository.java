package com.volkruss.misaka.domain.repository.user;

import com.volkruss.misaka.domain.model.user.Authorities;

import java.util.List;

public interface AuthoritiesRepository {
    List<Authorities> findByUserId(int id);
}
