package com.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dtos.ParkingAreaCapacityDTO;
import com.parking.models.ParkingArea;
import com.parking.services.ParkingAreaService;

@CrossOrigin
@RestController
@RequestMapping("/api/halls")
public class ParkingAreaController {
	@Autowired private ParkingAreaService service;

    @PostMapping("seats")
    public ResponseEntity<?> saveParkingAreaSeats(@RequestBody ParkingAreaCapacityDTO hc){
        service.saveCapacity(hc);
        return ResponseEntity.ok().body("Parking area Seats saved successfully");
    }
    
    @DeleteMapping("seats/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable("id") int id){
        service.deleteSeat(id);
        return ResponseEntity.ok("Seat deleted successfully");
    }
    
    @PostMapping
    public ResponseEntity<?> saveParkingArea(@RequestBody ParkingArea parkingArea){
        service.save(parkingArea);
        return ResponseEntity.ok().body("parking area saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(service.listall());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteParkingArea(@PathVariable("id") int id){
        service.deleteParkingArea(id);
        return ResponseEntity.ok("parking area deleted successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
