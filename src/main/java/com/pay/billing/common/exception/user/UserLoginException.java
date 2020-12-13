package com.pay.billing.common.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Unprocessable Entity
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UserLoginException extends RuntimeException {

    public UserLoginException(String msg) {
        super(msg);
    }

}
