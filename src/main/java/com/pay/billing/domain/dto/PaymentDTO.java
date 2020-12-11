package com.pay.billing.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentDTO {
	
	private Long id;
	
	private String crdtCardNum;
	
	private String validYm;
	
	private String cvc;
	
	private String encryptedCardInfo;
	
	private Long installment;
	
	private Long payAmount;
	
	private Long cancelAmount;
	
	private Long payVat;
	
	private Long cancelVat;
	
	private String apprYn;
	
	private String instDtm;
	 
}
