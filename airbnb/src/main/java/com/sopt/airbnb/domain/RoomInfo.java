package com.sopt.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class RoomInfo {

    @Column(name = "maxguests", nullable = false)
    private int maxGuests;

    @Column(name = "bedrooms", nullable = false)
    private int bedrooms;

    @Column(name = "beds", nullable = false)
    private int beds;

    @Column(name = "bathrooms", nullable = false)
    private float bathrooms;

    @Builder
    public RoomInfo(int maxGuests, int bedrooms, int beds, float bathrooms) {
        this.maxGuests = maxGuests;
        this.bedrooms = bedrooms;
        this.beds = beds;
        this.bathrooms = bathrooms;
    }
}
