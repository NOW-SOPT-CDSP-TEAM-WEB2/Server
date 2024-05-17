package com.sopt.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomid")
    private Long roomId;

    @Column(name = "roomimage", nullable = false, length = 200)
    private String roomImage;

    @Column(name = "roomlocation", nullable = false, length = 50)
    private String roomLocation;

    @Column(name = "roomrating", nullable = false, precision = 3, scale = 2)
    private BigDecimal roomRating;

    @Column(name = "currentdistance", nullable = false, length = 50)
    private String currentDistance;

    @Column(name = "recommendeddates", nullable = false, length = 30)
    private String recommendedDates;

    @Column(name = "guestreview", nullable = false, length = 30)
    private String guestReview;

    @Column(name = "roomprice", nullable = false, length = 30)
    private String roomPrice;

    @Column(name = "issuperhost", nullable = false)
    private Boolean isSuperHost;

    @Column(name = "iswishlist", nullable = false)
    private Boolean isWishList;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Builder
    public Room(
            String roomImage,
            String roomLocation,
            BigDecimal roomRating,
            String currentDistance,
            String recommendedDates,
            String guestReview,
            String roomPrice,
            Boolean isSuperHost,
            Boolean isWishList,
            BigDecimal latitude,
            BigDecimal longitude
    ) {
        this.roomImage = roomImage;
        this.roomLocation = roomLocation;
        this.roomRating = roomRating;
        this.currentDistance = currentDistance;
        this.recommendedDates = recommendedDates;
        this.guestReview = guestReview;
        this.roomPrice = roomPrice;
        this.isSuperHost = isSuperHost;
        this.isWishList = isWishList;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Room create(
            String roomImage,
            String roomLocation,
            BigDecimal roomRating,
            String currentDistance,
            String recommendedDates,
            String guestReview,
            String roomPrice,
            Boolean isSuperHost,
            Boolean isWishList,
            BigDecimal latitude,
            BigDecimal longitude
    ) {
        return Room.builder()
                .roomImage(roomImage)
                .roomLocation(roomLocation)
                .roomRating(roomRating)
                .currentDistance(currentDistance)
                .recommendedDates(recommendedDates)
                .guestReview(guestReview)
                .roomPrice(roomPrice)
                .isSuperHost(isSuperHost)
                .isWishList(isWishList)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }

    public void setIsWishList(Boolean isWishList) {
        this.isWishList = isWishList;
    }
}
