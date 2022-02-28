package com.volkruss.misaka.domain.repository.user;

import com.volkruss.misaka.domain.model.user.Role;
import java.util.List;

public interface RoleRepository {
    List<Role> getRoleByUserId(int userId);
}
