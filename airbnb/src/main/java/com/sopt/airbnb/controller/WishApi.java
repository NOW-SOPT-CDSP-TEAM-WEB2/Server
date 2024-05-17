package com.sopt.airbnb.controller;

import com.sopt.airbnb.common.dto.SuccessResponse;
import com.sopt.airbnb.common.dto.SuccessStatusResponse;
import com.sopt.airbnb.dto.RoomListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "좋아요 관련 API")
public interface WishApi {
    @Operation(
            summary = "위시(좋아요) 추가 API",
            description = "isWishList가 false일 때 좋아요 버튼을 누르면 true가 되는 API입니다. true가 되면 위시리스트에 추가됩니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "위시 리스트에 성공적으로 추가되었습니다."
                    )
            }
    )
    public ResponseEntity<SuccessResponse> addToWishlist(@PathVariable Long roomId);

    @Operation(
            summary = "위시(좋아요) 취소 API",
            description = "isWishList가 true일 때 좋아요 버튼을 누르면 false가 되는 API입니다. false가 되면 위시리스트에서 삭제됩니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "위시가 성공적으로 삭제되었습니다."
                    )
            }
    )
    public ResponseEntity<SuccessResponse> deleteToWishlist(@PathVariable Long roomId);

    @Operation(
            summary = "위시 리스트 반환 API",
            description = "위시리스트에 등록된 숙소 정보를 반환하는 API입니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "위시 리스트가 성공적으로 반환되었습니다.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = RoomListDto.class
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<SuccessStatusResponse> getWishlist();

}
