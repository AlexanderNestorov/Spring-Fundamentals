package com.example.exam24_10_21.repository;

import com.example.exam24_10_21.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query(
            value = "SELECT * from ships s WHERE s.user_id != ?1",
            nativeQuery = true
    )
    List<Ship> findAllByUserWhereIdNotMatch(Long id);


    @Query(
            value = "SELECT * from ships s WHERE s.user_id = ?1",
            nativeQuery = true
    )
    List<Ship> findAllByUserWhereIdMatch(Long id);

    @Query(
            value = "SELECT * from ships s WHERE s.name = ?1",
            nativeQuery = true
    )
    Ship findShipByName(String name);
}
