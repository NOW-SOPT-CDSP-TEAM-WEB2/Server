package com.sopt.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class RoomDetail {

    @Id
    @Column(name = "roomid")
    private Long roomId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "roomid")
    private Room room;

    @Column(name = "roomname", nullable = false, length = 64)
    private String roomName;

    @Embedded
    private RoomInfo roomInfo;

    @Column(name = "hostname", nullable = false, length = 16)
    private String hostName;

    @Column(name = "yearsofhosting", nullable = false)
    private int yearsOfHosting;

    @Column(name = "description", nullable = false, length = 1024)
    private String description;

    @Builder
    public RoomDetail(Room room, String roomName, RoomInfo roomInfo, String hostName, int yearsOfHosting,
                      String description) {
        this.room = room;
        this.roomId = room.getId();
        this.roomName = roomName;
        this.roomInfo = roomInfo;
        this.hostName = hostName;
        this.yearsOfHosting = yearsOfHosting;
        this.description = description;
    }

    public static RoomDetail create(Room room, String roomName, RoomInfo roomInfo, String hostName, int yearsOfHosting,
                                    String description) {
        return RoomDetail.builder()
                .room(room)
                .roomName(roomName)
                .roomInfo(roomInfo)
                .hostName(hostName)
                .yearsOfHosting(yearsOfHosting)
                .description(description)
                .build();
    }
}
