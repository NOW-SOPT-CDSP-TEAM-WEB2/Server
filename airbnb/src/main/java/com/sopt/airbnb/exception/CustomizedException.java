package com.sopt.airbnb.exception;


import com.sopt.airbnb.common.dto.ErrorMessage;

public class CustomizedException extends BusinessException {
    public CustomizedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}