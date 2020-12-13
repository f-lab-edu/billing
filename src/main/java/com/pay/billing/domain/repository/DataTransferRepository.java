package com.pay.billing.domain.repository;

import com.pay.billing.domain.model.DataTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTransferRepository extends JpaRepository<DataTransfer, Long> {

}
