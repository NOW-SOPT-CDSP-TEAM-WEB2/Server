package com.sopt.airbnb.dto;

import java.math.BigDecimal;

public record RoomListResponse(Long roomId,
                               String roomImage,
                               String roomLocation,
                               BigDecimal roomRating,
                               String currentDistance,
                               String recommendedDates,
                               String guestReview,
                               String roomPrice,
                               Boolean isSuperHost,
                               Boolean isWishList) {

}
