package com.volkruss.misaka.web.repository.user;

import com.volkruss.misaka.domain.dao.user.RoleJpa;
import com.volkruss.misaka.domain.model.user.Role;
import com.volkruss.misaka.domain.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private RoleJpa roleJpa;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Role> getRoleByUserId(int userId){
        List<Role> roles = entityManager
                .createNativeQuery("select * from roles where user_id = :user_id", Role.class)
                .setParameter("user_id", userId)
                .getResultList();
        return roles;
    }
}
