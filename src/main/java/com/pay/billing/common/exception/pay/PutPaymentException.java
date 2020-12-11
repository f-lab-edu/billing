package com.pay.billing.common.exception.pay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PutPaymentException extends RuntimeException {

    public PutPaymentException(String msg) {
        super(msg);
    }

}
