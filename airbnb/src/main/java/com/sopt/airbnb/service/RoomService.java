package com.sopt.airbnb.service;

import com.sopt.airbnb.dto.RoomListDto;
import com.sopt.airbnb.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomListDto findRoomList() {
        return RoomListDto.create(roomRepository.findAll());
    }
}
