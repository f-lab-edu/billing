package com.pay.billing.common.security;

import com.pay.billing.domain.model.User;
import com.pay.billing.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
/*
1. UserDetails 인터페이스는 사용자 관련 데이터를 검색하는데 사용한다.
2. 사용자 이름을 기반으로 사용자 엔터티를 찾는 loadUserByUsername() 이라는
하나의 메서드가 있으며 이를 재정 의하여 사용자를 찾는 프로세스를 사용자 지정
 */
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(user.getRoleDTOS())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}
