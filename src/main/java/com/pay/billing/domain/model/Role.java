package com.pay.billing.domain.model;

import org.springframework.security.core.GrantedAuthority;

// 액세스 권한을 부여, 제어하는 ​​권한을 얻는다.
public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_CLIENT;

    public String getAuthority() {
        return name();
    }
}
