package com.pay.billing.domain.model;

import com.pay.billing.domain.model.common.CommonEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
// 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성
@AllArgsConstructor
// 파라미터가 없는 생성자를 생성
@NoArgsConstructor
@Builder
public class Payment extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length=20, nullable=false)
	private String crdtCardNum;
	
	@Column(length=4, nullable=false)
	private String validYm;
	
	@Column(length=3, nullable=false)
	private String cvc;
	
	@Column(nullable=false)
	private String encryptedCardInfo;
	
	@Column(length=2, nullable=false)
	private Long installment;
	
	@Column(length=10, nullable=false)
	private Long payAmount;

	@Column(length=10)
	private Long cancelAmount;
	
	@Column(length=10, nullable=false)
	private Long payVat;
	
	@Column(length=10)
	private Long cancelVat;
	
	@Column
	private String note;
}
