package com.parking.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.ParkingArea;
import com.parking.models.ParkingAreaCapacity;

@Repository
public interface ParkingAreaCapacityRepository extends JpaRepository<ParkingAreaCapacity, Integer> {
	
	List<ParkingAreaCapacity> findByHall(ParkingArea hall);

}
