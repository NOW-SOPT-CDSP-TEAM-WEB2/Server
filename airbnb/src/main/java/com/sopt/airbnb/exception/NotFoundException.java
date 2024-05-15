package com.sopt.airbnb.exception;

import com.sopt.airbnb.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException {

    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
