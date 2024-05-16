package com.sopt.airbnb.controller;

import com.sopt.airbnb.dto.RoomListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(name = "숙소 관련 API")
public interface RoomApi {

    @Operation(
            summary = "숙소 리스트 조회 API",
            description = "전체 숙소 목록을 조회하는 API입니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "숙소 리스트 조회 성공",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = RoomListDto.class
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<RoomListDto> getRoomList();
}
