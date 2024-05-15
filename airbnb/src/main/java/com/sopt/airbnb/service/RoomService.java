package com.sopt.airbnb.service;

import com.sopt.airbnb.repository.RoomRepository;
import com.sopt.airbnb.service.dto.RoomListDto;
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
