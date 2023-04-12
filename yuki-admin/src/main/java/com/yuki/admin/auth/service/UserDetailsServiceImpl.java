package com.yuki.admin.auth.service;

import com.yuki.common.core.domain.model.UserSession;
import com.yuki.admin.auth.entity.SystemUser;
import com.yuki.admin.auth.repo.SystemUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepo systemUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserRepo.findByUsername(username);
        if (systemUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new UserSession(systemUser.getId(), systemUser.getUsername(), systemUser.getPassword());
    }
}
