package com.pay.billing.common.exception.pay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GetPaymentException extends RuntimeException {

    public GetPaymentException(String msg) {
        super(msg);
    }

}
