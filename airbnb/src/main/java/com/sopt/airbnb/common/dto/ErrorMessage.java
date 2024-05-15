package com.sopt.airbnb.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor//전체 생성자
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    UNAUTHORIZED_ACCESS(HttpStatus.UNAUTHORIZED.value(), "접근 권한이 없습니다."),
      ;
    private final int status;
    private final String message;

}