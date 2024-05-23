package com.sopt.airbnb.dto;

import java.time.LocalDate;

public record RoomBookingRequest(
        LocalDate checkInDate,
        LocalDate checkOutDate,
        Integer headCount,
        String messageToHost
) {
}
