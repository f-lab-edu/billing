package com.pay.billing.domain.model.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// 객체의 입장에서 공통 매핑 정보가 필요할 때 사용 (id, name ...)
@MappedSuperclass
// 엔티티를 DB에 적용하기 이전 이후에 커스텀 콜백을 요청할 수 있는 어노테이션 입니다.
@EntityListeners(AuditingEntityListener.class)
public abstract class CommonEntity {
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime insertDateTime;
	
	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime modifyDateTime;
	
}
