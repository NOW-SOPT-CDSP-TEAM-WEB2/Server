package com.sopt.airbnb.controller;


import com.sopt.airbnb.common.dto.SuccessMessage;
import com.sopt.airbnb.common.dto.SuccessResponse;
import com.sopt.airbnb.common.dto.SuccessStatusResponse;
import com.sopt.airbnb.domain.Room;
import com.sopt.airbnb.dto.WishListResponse;
import com.sopt.airbnb.service.WishService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WishController implements WishApi {

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
        WishListResponse wishListResponse = WishListResponse.create(wishlist);
        return ResponseEntity.ok(SuccessStatusResponse.of(
                SuccessMessage.WISHLIST_GET_SUCCESS.getStatus(),
                SuccessMessage.WISHLIST_GET_SUCCESS.getMessage(),
                wishListResponse));
    }

}
