package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.RoomDetail;
import lombok.Builder;

@Builder
public record RoomDetailInfo(
        Long roomId,
        String roomName,
        RoomFacilityInfo roomInfo,
        String hostName,
        int yearsOfHosting,
        String description
) {
    public static RoomDetailInfo of(RoomDetail roomDetail) {
        return RoomDetailInfo.builder()
                .roomId(roomDetail.getRoom().getId())
                .roomName(roomDetail.getRoomName())
                .roomInfo(RoomFacilityInfo.of(roomDetail.getRoomInfo()))
                .hostName(roomDetail.getHostName())
                .yearsOfHosting(roomDetail.getYearsOfHosting())
                .description(roomDetail.getDescription())
                .build();
    }
}
