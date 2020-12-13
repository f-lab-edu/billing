package com.pay.billing.domain.repository;


import com.pay.billing.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    /*
    프록시 객체는 @Transactional이 포함된 메소드가 호출 될 경우, PlatformTransactionManager를
    사용하여 트랜잭션을 시작하고, 정상 여부에 따라 Commit 또는 Rollback 한다.
    */
    @Transactional
    void deleteByUsername(String username);

}
