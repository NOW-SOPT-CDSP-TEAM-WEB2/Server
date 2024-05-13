package com.hapjuhasil.server.exception;

import com.hapjuhasil.server.common.dto.ErrorMessage;

public class CustomizedException extends BusinessException {
    public CustomizedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}