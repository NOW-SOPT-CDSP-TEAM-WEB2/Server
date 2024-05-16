package com.sopt.airbnb.controller;


import com.sopt.airbnb.common.dto.SuccessMessage;
import com.sopt.airbnb.common.dto.SuccessResponse;
import com.sopt.airbnb.common.dto.SuccessStatusResponse;
import com.sopt.airbnb.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WishController {

    private final WishService wishService;

    @PostMapping("/wishes/{roomId}")
    public ResponseEntity<SuccessResponse> addToWishlist(@PathVariable Long roomId) {
        wishService.updateWishListStatus(roomId, true);
        return ResponseEntity.ok(SuccessResponse.of(SuccessMessage.WISH_SUCCESS));
    }






}
