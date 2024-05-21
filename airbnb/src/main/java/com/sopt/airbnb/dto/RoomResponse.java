package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.Room;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;

@Builder
public record RoomResponse(
        Long roomId,
        List<String> roomImageList,
        String roomLocation,
        BigDecimal roomRating,
        String currentDistance,
        String recommendedDates,
        String guestReview,
        int roomPrice,
        Boolean isSuperHost,
        Boolean isWishList
) {
    public static RoomResponse of(Room room) {
        return RoomResponse.builder()
                .roomId(room.getRoomId())
                .roomImageList(room.getRoomImageList())
                .roomLocation(room.getRoomLocation())
                .roomRating(room.getRoomRating())
                .currentDistance(room.getCurrentDistance())
                .recommendedDates(room.getRecommendedDates())
                .guestReview(room.getGuestReview())
                .roomPrice(room.getRoomPrice())
                .isSuperHost(room.getIsSuperHost())
                .isWishList(room.getIsWishList())
                .build();
    }

    public static List<RoomResponse> create(List<Room> originalRooms) {
        return originalRooms.stream()
                .map(RoomResponse::of)
                .collect(Collectors.toList());
    }
}
