package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.Room;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record WishResponse(
        RoomResponse roomResponse,
        BigDecimal latitude,
        BigDecimal longitude
) {
    public static WishResponse of(Room room) {
        return new WishResponse(
                RoomResponse.of(room),
                room.getLatitude(),
                room.getLongitude()
        );
    }

    public static List<WishResponse> create(List<Room> originalRooms) {
        return originalRooms.stream()
                .map(WishResponse::of)
                .collect(Collectors.toList());
    }
}
