package com.parking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.Park;

@Repository
public interface ParkRepository extends JpaRepository<Park, Integer>{

}
