package com.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.parking.models.Park;
import com.parking.services.ParkService;

@CrossOrigin
@RestController
@RequestMapping("/api/parks")
public class ParkController {
	@Autowired private ParkService mService;

    @PostMapping
    public ResponseEntity<?> savePark(Park park,@RequestPart(required = false) MultipartFile photo){
        mService.save(park,photo);
        return ResponseEntity.ok().body("Park saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(mService.listall());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePark(@PathVariable("id") int id){
        mService.deletePark(id);
        return ResponseEntity.ok("Park deleted successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(mService.findById(id));
    }
}
