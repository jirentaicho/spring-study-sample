package com.volkruss.misaka.domain.dao.user;

import com.volkruss.misaka.domain.model.user.Authorities;
import com.volkruss.misaka.domain.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Permission;
import java.util.List;

public interface AuthoritiesJpa extends JpaRepository<Authorities,Integer> {
}
