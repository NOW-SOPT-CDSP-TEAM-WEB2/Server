package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.Room;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;

@Builder
public record RoomListResponse(
        Long roomId,
        List<String> roomImageList,
        String roomLocation,
        BigDecimal roomRating,
        String currentDistance,
        String recommendedDates,
        String guestReview,
        String roomPrice,
        Boolean isSuperHost,
        Boolean isWishList
) {
    public static RoomListResponse of(Room room) {
        return RoomListResponse.builder()
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

    public static List<RoomListResponse> create(List<Room> originalRooms) {
        return originalRooms.stream()
                .map(RoomListResponse::of)
                .collect(Collectors.toList());
    }
}
