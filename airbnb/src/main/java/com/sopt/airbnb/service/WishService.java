package com.sopt.airbnb.service;

import com.sopt.airbnb.common.dto.ErrorMessage;
import com.sopt.airbnb.domain.Room;
import com.sopt.airbnb.exception.CustomizedException;
import com.sopt.airbnb.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishService {

    private final RoomRepository roomRepository;
    public void updateWishListStatus(Long roomId, Boolean isWishList) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new CustomizedException(ErrorMessage.ROOM_NOT_FOUND_BY_ID_EXCEPTION));
        room.setIsWishList(isWishList);
        roomRepository.save(room);
    }

}
