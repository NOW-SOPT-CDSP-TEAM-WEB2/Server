package com.hapjuhasil.server.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor//전체 생성자
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    OWNER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 합주실 사장님이 존재하지 않습니다."),
    ENSEMBLE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 합주실이 존재하지 않습니다."),
    UNAUTHORIZED_ACCESS(HttpStatus.UNAUTHORIZED.value(), "접근 권한이 없습니다."),
    POST_NOT_FOUND_BY_POST_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "글이 존재하지 않습니다."),
    ENSEMBLE_NOT_FOUND_BY_OWNER_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "해당 사장님의 합주실이 존재하지 않습니다."),
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "룸이 존재하지 않습니다."),
    ;
    private final int status;
    private final String message;

}