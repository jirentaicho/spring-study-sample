package com.volkruss.misaka.web.security;

import com.volkruss.misaka.domain.model.user.Authorities;
import com.volkruss.misaka.domain.model.user.Role;
import com.volkruss.misaka.domain.model.user.User;
import com.volkruss.misaka.domain.repository.user.AuthoritiesRepository;
import com.volkruss.misaka.domain.repository.user.RoleRepository;
import com.volkruss.misaka.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// SecurityConfig側で設定は不要で反映されます。
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //　dbからユーザーを取得する
        User user = this.userRepository.findByUserName(username);

        // ユーザーの権限を取得する
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        List<Role> roles = this.roleRepository.getRoleByUserId(user.getId());
        List<Authorities> userAuthorities = this.authoritiesRepository.findByUserId(1);

        List<GrantedAuthority> roleKeys = roles.stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        List<GrantedAuthority> authorityKeys = userAuthorities.stream()
                .map(Authorities::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        authorities.addAll(roleKeys);
        authorities.addAll(authorityKeys);

        // TODO 継承したログインユーザークラスの作成と返却を行う
        return new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), authorities);
    }

}

