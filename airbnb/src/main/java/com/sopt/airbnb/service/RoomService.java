package com.sopt.airbnb.service;

import com.sopt.airbnb.common.dto.ErrorMessage;
import com.sopt.airbnb.domain.RoomDetail;
import com.sopt.airbnb.dto.RoomDetailResponse;
import com.sopt.airbnb.dto.RoomListResponse;
import com.sopt.airbnb.exception.CustomizedException;
import com.sopt.airbnb.repository.RoomRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomListResponse> findRoomList() {
        return RoomListResponse.create(roomRepository.findAll());
    }

    public RoomDetailResponse findRoomDetailByRoomId(
            Long roomId
    ) {
        RoomDetail roomDetail = roomRepository.findById(roomId)
                .orElseThrow(() -> new CustomizedException(ErrorMessage.ROOM_NOT_FOUND_BY_ID_EXCEPTION))
                .getRoomDetail();

        return RoomDetailResponse.of(roomDetail);
    }
}
