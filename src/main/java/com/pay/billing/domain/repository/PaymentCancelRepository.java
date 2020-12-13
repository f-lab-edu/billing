package com.pay.billing.domain.repository;

import com.pay.billing.domain.model.PaymentCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCancelRepository extends JpaRepository<PaymentCancel, Long> {

}
