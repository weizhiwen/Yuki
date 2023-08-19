package com.yuki.admin.auth.service;

import com.yuki.admin.auth.dao.SystemUser;
import com.yuki.admin.auth.dao.SystemUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepo systemUserRepo;

    @Override
    public SystemUser loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = systemUserRepo.findByLoginName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
