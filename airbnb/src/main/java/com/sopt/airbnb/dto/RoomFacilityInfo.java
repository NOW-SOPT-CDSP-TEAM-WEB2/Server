package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.RoomInfo;
import lombok.Builder;

@Builder
public record RoomFacilityInfo(
        int maxGuests,
        int bedrooms,
        int beds,
        float bathrooms
) {
    public static RoomFacilityInfo of(RoomInfo roomInfo) {
        return RoomFacilityInfo.builder()
                .maxGuests(roomInfo.getMaxGuests())
                .bedrooms(roomInfo.getBedrooms())
                .beds(roomInfo.getBeds())
                .bathrooms(roomInfo.getBathrooms())
                .build();
    }
}
