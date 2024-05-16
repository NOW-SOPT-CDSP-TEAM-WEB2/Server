package com.sopt.airbnb.controller;

import com.sopt.airbnb.service.RoomService;
import com.sopt.airbnb.service.dto.RoomListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<RoomListDto> getRoomList() {
        return ResponseEntity.ok(roomService.findRoomList());
    }
}