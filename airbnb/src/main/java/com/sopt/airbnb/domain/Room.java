package com.sopt.airbnb.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;
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

    @ElementCollection
    @CollectionTable(name = "roomimages", joinColumns = @JoinColumn(name = "roomid"))
    @Column(name = "roomimage", nullable = false)
    private List<String> roomImageList;

    @Column(name = "roomlocation", nullable = false, length = 64)
    private String roomLocation;

    @Column(name = "roomrating", nullable = false, precision = 3, scale = 2)
    private BigDecimal roomRating;

    @Column(name = "currentdistance", nullable = false, length = 32)
    private String currentDistance;

    @Column(name = "recommendeddates", nullable = false, length = 32)
    private String recommendedDates;

    @Column(name = "guestreview", nullable = false, length = 16)
    private String guestReview;

    @Column(name = "roomprice", nullable = false)
    private int roomPrice;

    @Column(name = "issuperhost", nullable = false)
    private Boolean isSuperHost;

    @Column(name = "iswishlist", nullable = false)
    private Boolean isWishList;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL, optional = false)
    private RoomDetail roomDetail;

    @Builder
    public Room(
            List<String> roomImageList,
            String roomLocation,
            BigDecimal roomRating,
            String currentDistance,
            String recommendedDates,
            String guestReview,
            int roomPrice,
            Boolean isSuperHost,
            Boolean isWishList,
            BigDecimal latitude,
            BigDecimal longitude
    ) {
        this.roomImageList = roomImageList;
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
            List<String> roomImageList,
            String roomLocation,
            BigDecimal roomRating,
            String currentDistance,
            String recommendedDates,
            String guestReview,
            int roomPrice,
            Boolean isSuperHost,
            Boolean isWishList,
            BigDecimal latitude,
            BigDecimal longitude
    ) {
        return Room.builder()
                .roomImageList(roomImageList)
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
