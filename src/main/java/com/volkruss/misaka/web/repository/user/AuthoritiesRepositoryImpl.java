package com.volkruss.misaka.web.repository.user;

import com.volkruss.misaka.domain.dao.user.AuthoritiesJpa;
import com.volkruss.misaka.domain.model.user.Authorities;
import com.volkruss.misaka.domain.repository.user.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AuthoritiesRepositoryImpl implements AuthoritiesRepository {
    @Autowired
    private AuthoritiesJpa permissionJpa;

    @Override
    public List<Authorities> findByUserId(int id) {
        return List.of(
                new Authorities(1,1,"brows"),
                new Authorities(2,1,"update")
        );
    }
}
