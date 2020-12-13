package com.pay.billing.domain.model;

import com.pay.billing.domain.dto.RoleDTO;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/*
JPA에서 사용할 엔티티 이름을 지정한다. 보통 기본값인 클래스 이름을 사용한다.
만약 다른 패키지에 이름이 같은 엔티티 클래스가 있다면 이름을 지정해서 충돌하지 않도록 해야 한다.

- 방법
1. 객체와 테이블 매핑    @Entity, @Table
2. 기본 키 매핑         @Id
3. 필드와 컬럼 매핑	  @Column
4. 연관관계 매핑	      @ManyToOne, @JoinColumn

- 주의 사항
1. 기본 생성자가 필수(파라미터가 없는 public 또는 protected 생성자)
2. final 클래스, enum, interface, inner 클래스에는 사용 불가
3. 저장할 필드에 final 사용 불가
*/
@Entity
public class User {

    @Id // @Id는 해당 프로퍼티가 테이블의 주키(primary key) 역할을 한다는 것을 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue는 주키의 값을 위한 자동 생성 전략을 명시하는데 사용한다.
    private Integer id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters") // 필드의 크기 를 전달
    @Column(unique = true, nullable = false) // DDL 문을 제어하는 ​​데 사용 하는 JPA 주석
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    /*
    @ElementCollection을 통해 값을 추가할 경우, JPA 구현체는 해당 컬렉션의 모든 데이터를 삭제하고 다시 모든 데이터를 추가한다
    @ElementCollection의 fetch 속성을 EAGER로 설정했으면 Hibernate에서 제공하는 @Fetch로 긁어올 방식을 설정해 주어야 한다.
    @ElementCollection으로 @Embeddable을 저장할 경우 관계 Key가 되는 값이 부모의 PK가 아닌 다른 컬럼이어도 작동은 한다.
    하지만 부모의 컬렉션을 로딩한 상태에서 자식들을 로딩하면 각 부모 객체가 동일한 관계 Key를 가지고 있을 경우 별다른 오류 메시지 없이 오류로 간주하고 rollback이 된다.
    @ElementCollection의 관계 Key는 부모의 PK나 혹은 PK에 준하는 각 부모별로 동일한 값이 나올 수 없는 것으로 지정해야 한다.
    */
    @ElementCollection(fetch = FetchType.EAGER)
    List<RoleDTO> roleDTOS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoleDTOS() {
        return roleDTOS;
    }

    public void setRoleDTOS(List<RoleDTO> roleDTOS) {
        this.roleDTOS = roleDTOS;
    }

}
