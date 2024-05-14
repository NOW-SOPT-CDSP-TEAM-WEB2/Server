package org.sopt.practice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    UPDATE_SUCCESS(HttpStatus.OK.value(), "정보 업데이트가 완료되었습니다."),
    ;
    private final int status;
    private final String message;
}
