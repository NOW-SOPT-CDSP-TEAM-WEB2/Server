package com.sopt.airbnb.service;

import com.sopt.airbnb.common.dto.ErrorMessage;
import com.sopt.airbnb.common.dto.SuccessMessage;
import com.sopt.airbnb.common.dto.SuccessResponse;
import com.sopt.airbnb.domain.RoomDetail;
import com.sopt.airbnb.dto.RoomBookingRequest;
import com.sopt.airbnb.dto.RoomDetailResponse;
import com.sopt.airbnb.dto.RoomResponse;
import com.sopt.airbnb.exception.CustomizedException;
import com.sopt.airbnb.repository.RoomRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomResponse> findRoomList() {
        return RoomResponse.create(roomRepository.findAll());
    }

    public RoomDetailResponse findRoomDetailByRoomId(
            Long roomId
    ) {
        RoomDetail roomDetail = roomRepository.findById(roomId)
                .orElseThrow(() -> new CustomizedException(ErrorMessage.ROOM_NOT_FOUND_BY_ID_EXCEPTION))
                .getRoomDetail();

        return RoomDetailResponse.of(roomDetail);
    }

    public SuccessResponse validCheckInOutDate(RoomBookingRequest bookingRequest) {
        LocalDate checkInDate = bookingRequest.checkInDate();
        LocalDate checkOutDate = bookingRequest.checkOutDate();

        if (!checkInDate.isBefore(checkOutDate)) {
            throw new CustomizedException(ErrorMessage.INVALID_CHECKIN_CHECKOUT_DATE_EXCEPTION);
        }

        return SuccessResponse.of(SuccessMessage.ROOM_BOOKING_POST_SUCCESS);
    }
}
