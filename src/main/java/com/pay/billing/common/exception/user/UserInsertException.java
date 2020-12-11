package com.pay.billing.common.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UserInsertException extends RuntimeException {

    public UserInsertException(String msg) {
        super(msg);
    }

}
