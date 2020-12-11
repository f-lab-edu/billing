package com.pay.billing.controller;

import com.pay.billing.common.exception.pay.GetPaymentException;
import com.pay.billing.common.exception.pay.PostPaymentException;
import com.pay.billing.common.exception.pay.PutPaymentException;
import com.pay.billing.domain.dto.PaymentDTO;
import com.pay.billing.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RequestMapping(value = "/payment")
@RestController
public class PaymentController {

    private PaymentService paymentService;

    // 결제 진행
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> postPayment(@RequestBody PaymentDTO paymentDTO) {
        if (paymentDTO.getCrdtCardNum() == null || paymentDTO.getCvc() == null
                || paymentDTO.getInstallment() == null || paymentDTO.getPayAmount() == null || paymentDTO.getValidYm() == null) {
            throw new PostPaymentException("postPayment Parameter Error");
        }

        Map<String, Object> result = new HashMap<String, Object>();

        try {
            result = paymentService.postPaymentData(paymentDTO);
        } catch (Exception e) {

        }

        return result;

    }

    // 결제 내역 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getPayment(@RequestBody PaymentDTO paymentDTO) {
        if (paymentDTO.getId() == null) {
            throw new GetPaymentException("getPayment Parameter Error");
        }

        return paymentService.getPaymentData(paymentDTO);
    }

    // 결제 취소 (전체/부분)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> putPayment(@RequestBody PaymentDTO paymentDTO) {
        if (paymentDTO.getCancelAmount() == null) {
            throw new PutPaymentException("putPayment Parameter Error");
        }

        if (paymentDTO.getCancelVat() != null && paymentDTO.getCancelVat() > paymentDTO.getCancelAmount()) {
            throw new PutPaymentException("Vat is bigger than Amout");
        }

        return paymentService.putPaymentData(paymentDTO);

    }
}
