package com.pay.billing.service;

import com.pay.billing.domain.dto.PaymentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    /**
     * 신규거래 등록
     *
     * @param paymentDTO
     */
    @Transactional
    public Map<String, Object> postPaymentData(PaymentDTO paymentDTO) throws Exception {
        Map<String, Object> outputMap = new HashMap<String, Object>();

        return outputMap;
    }

    /**
     * 거래 조회
     *
     * @param paymentDTO
     */
    public Map<String, Object> getPaymentData(PaymentDTO paymentDTO) {
        Map<String, Object> outputMap = new HashMap<String, Object>();
        Map<String, Object> cardInfo = new HashMap<String, Object>();
        Map<String, Object> amountInfo = new HashMap<String, Object>();
        Long cancelAmt;

        Long id = paymentDTO.getId();
        //Optional<Payment> payment = paymentRepository.findById(id);

        return outputMap;
    }

    /**
     * 결제 취소(전체/부분)
     *
     * @param paymentDTO
     */
    public Map<String, Object> putPaymentData(PaymentDTO paymentDTO) {
        Map<String, Object> outputMap = new HashMap<String, Object>();


        return outputMap;
    }
}
