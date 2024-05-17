package com.sopt.airbnb.repository;

import com.sopt.airbnb.domain.Room;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long id);
    List<Room> findByIsWishListTrue();

}
