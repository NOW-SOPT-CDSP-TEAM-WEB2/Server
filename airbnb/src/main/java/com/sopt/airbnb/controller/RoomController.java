package com.sopt.airbnb.controller;

import com.sopt.airbnb.dto.RoomDetailResponse;
import com.sopt.airbnb.dto.RoomListResponse;
import com.sopt.airbnb.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService roomService;

    @GetMapping
    @Override
    public ResponseEntity<List<RoomListResponse>> getRoomList() {
        return ResponseEntity.ok(roomService.findRoomList());
    }

    @GetMapping("{roomId}")
    @Override
    public ResponseEntity<RoomDetailResponse> getRoomDetail(
            @PathVariable Long roomId
    ) {
        return ResponseEntity.ok(roomService.findRoomDetailByRoomId(roomId));
    }
}
