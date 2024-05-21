package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.RoomDetail;
import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;

@Builder
public record RoomDetailResponse(
        List<String> roomImageList,
        String roomLocation,
        BigDecimal roomRating,
        Boolean isSuperHost,
        int roomPrice,
        BigDecimal latitude,
        BigDecimal longitude,
        RoomDetailInfo roomDetail
) {
    public static RoomDetailResponse of(RoomDetail roomDetail) {
        return RoomDetailResponse.builder()
                .roomImageList(roomDetail.getRoom().getRoomImageList())
                .roomLocation(roomDetail.getRoom().getRoomLocation())
                .roomRating(roomDetail.getRoom().getRoomRating())
                .isSuperHost(roomDetail.getRoom().getIsSuperHost())
                .roomPrice(roomDetail.getRoom().getRoomPrice())
                .latitude(roomDetail.getRoom().getLatitude())
                .longitude(roomDetail.getRoom().getLongitude())
                .roomDetail(RoomDetailInfo.of(roomDetail))
                .build();
    }
}
