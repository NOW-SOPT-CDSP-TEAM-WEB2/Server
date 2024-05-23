package com.sopt.airbnb.controller;

import com.sopt.airbnb.common.dto.SuccessResponse;
import com.sopt.airbnb.dto.RoomBookingRequest;
import com.sopt.airbnb.dto.RoomDetailResponse;
import com.sopt.airbnb.dto.RoomResponse;
import com.sopt.airbnb.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService roomService;

    @GetMapping
    @Override
    public ResponseEntity<List<RoomResponse>> getRoomList() {
        return ResponseEntity.ok(roomService.findRoomList());
    }


    @GetMapping("{roomId}")
    @Override
    public ResponseEntity<RoomDetailResponse> getRoomDetail(
            @PathVariable Long roomId
    ) {
        return ResponseEntity.ok(roomService.findRoomDetailByRoomId(roomId));
    }

    @PostMapping("{roomId}")
    @Override
    public ResponseEntity<SuccessResponse> addRoomBooking(
            @PathVariable Long roomId,
            @RequestBody RoomBookingRequest roomBookingRequest
    ) {
        SuccessResponse response = roomService.validCheckInOutDate(roomBookingRequest);
        return ResponseEntity.status(201).body(response);
    }
}
