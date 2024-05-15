package com.sopt.airbnb.repository;

import com.sopt.airbnb.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
