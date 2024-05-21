package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.Room;
import java.util.Collections;
import java.util.List;

public record WishListResponse(
        List<Room> rooms
) {
    public static WishListResponse create(List<Room> originalRooms) {
        List<Room> unmodifiableRooms = Collections.unmodifiableList(originalRooms);

        return new WishListResponse(unmodifiableRooms);
    }
}
