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
public class DataTransfer extends CommonEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length=450, nullable=false)
	private String transferData;
	
	@Column(length=1, nullable=false)
	private String successYn;
}
