package com.sopt.airbnb.controller;


import com.sopt.airbnb.common.dto.SuccessMessage;
import com.sopt.airbnb.common.dto.SuccessResponse;
import com.sopt.airbnb.common.dto.SuccessStatusResponse;
import com.sopt.airbnb.domain.Room;
import com.sopt.airbnb.dto.RoomListDto;
import com.sopt.airbnb.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WishController implements WishApi{

    private final WishService wishService;

    @Override
    @PostMapping("/wishes/{roomId}")
    public ResponseEntity<SuccessResponse> addToWishlist(@PathVariable Long roomId) {
        wishService.updateWishListStatus(roomId, true);
        return ResponseEntity.ok(SuccessResponse.of(SuccessMessage.WISH_POST_SUCCESS));
    }

    @Override
    @DeleteMapping("/wishes/{roomId}")
    public ResponseEntity<SuccessResponse> deleteToWishlist(@PathVariable Long roomId) {
        wishService.updateWishListStatus(roomId, false);
        return ResponseEntity.ok(SuccessResponse.of(SuccessMessage.WISH_DELETE_SUCCESS));
    }

    @Override
    @GetMapping("/wishes")
    public ResponseEntity<SuccessStatusResponse> getWishlist() {
        List<Room> wishlist = wishService.getWishlist();
        RoomListDto roomListDto = RoomListDto.create(wishlist);
        return ResponseEntity.ok(SuccessStatusResponse.of(
                SuccessMessage.WISHLIST_GET_SUCCESS.getStatus(),
                SuccessMessage.WISHLIST_GET_SUCCESS.getMessage(),
                roomListDto));
    }


}
