package com.sopt.airbnb.controller;

import com.sopt.airbnb.dto.RoomDetailResponse;
import com.sopt.airbnb.dto.RoomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

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
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = RoomResponse.class
                                            )
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<List<RoomResponse>> getRoomList();

    @Operation(
            summary = "숙소 상세정보 조회 API",
            description = "숙소 상세정보를 조회하는 API입니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "숙소 상세정보 조회 성공",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = RoomDetailResponse.class
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<RoomDetailResponse> getRoomDetail(
            @PathVariable Long roomId
    );
}
