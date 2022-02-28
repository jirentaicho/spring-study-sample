package com.volkruss.misaka.domain.dao.user;

import com.volkruss.misaka.domain.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleJpa extends JpaRepository<Role,Integer> {

}
