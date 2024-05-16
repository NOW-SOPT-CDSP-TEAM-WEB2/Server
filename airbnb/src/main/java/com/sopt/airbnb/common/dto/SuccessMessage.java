package com.sopt.airbnb.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    POST_SUCCESS(HttpStatus.CREATED.value(), "등록이 완료되었습니다."),
    WISH_SUCCESS(HttpStatus.OK.value(), "위시에 등록되었습니다."),
    ;
    private final int status;
    private final String message;

}
