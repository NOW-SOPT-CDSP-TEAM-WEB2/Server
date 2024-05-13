package com.hapjuhasil.server.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    ENSEMBLE_POST_SUCCESS(HttpStatus.CREATED.value(), "합주실 등록이 완료되었습니다."),
    ROOM_CREATE_SUCCESS(HttpStatus.CREATED.value(), "합주실 방 등록이 완료되었습니다."),
    OWNER_CREATE_SUCCESS(HttpStatus.CREATED.value(), "합주실 사장 등록이 완료되었습니다."),
    ENSEMBLE_ALL_FIND_SUCCESS(HttpStatus.OK.value(), "합주실을 모두 불러왔습니다."),
    ENSEMBLE_FIND_SUCCESS(HttpStatus.OK.value(), "요청한 합주실을 불러왔습니다."),
    ENSEMBLE_UPDATE_SUCCESS(HttpStatus.OK.value(), "합주실 정보 업데이트가 완료되었습니다."),
    ;
    private final int status;
    private final String message;
}
