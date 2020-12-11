package com.pay.billing.common.exception.pay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PostPaymentException extends RuntimeException {

    public PostPaymentException(String msg) {
        super(msg);
    }

}
