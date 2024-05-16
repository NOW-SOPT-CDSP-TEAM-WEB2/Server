package com.sopt.airbnb.controller;

import com.sopt.airbnb.service.RoomService;
import com.sopt.airbnb.service.dto.RoomListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "숙소 관련 API")
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

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
    @GetMapping
    public ResponseEntity<RoomListDto> getRoomList() {
        return ResponseEntity.ok(roomService.findRoomList());
    }
}
