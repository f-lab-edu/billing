package com.pay.billing.domain.model;

import com.pay.billing.domain.model.common.CommonEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCancel extends CommonEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Long paymentId;
	
	@Column(length=10, nullable=false)
	private Long cancelAmount;
	
	@Column(length=10, nullable=false)
	private Long vat;
}
