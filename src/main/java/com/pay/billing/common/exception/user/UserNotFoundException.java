package com.pay.billing.common.exception.user;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private String memberId;

    public UserNotFoundException(String memberId) {
        super("Member not found : " +memberId);
    }
}
