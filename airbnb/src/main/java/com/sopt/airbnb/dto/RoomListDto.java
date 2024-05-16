package com.sopt.airbnb.dto;

import com.sopt.airbnb.domain.Room;
import java.util.Collections;
import java.util.List;

public record RoomListDto(
        List<Room> rooms
) {
    public static RoomListDto create(List<Room> originalRooms) {
        List<Room> unmodifiableRooms = Collections.unmodifiableList(originalRooms);

        return new RoomListDto(unmodifiableRooms);
    }
}
