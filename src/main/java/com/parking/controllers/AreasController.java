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

import com.parking.dtos.SearchDTO;
import com.parking.dtos.AreasDTO;
import com.parking.services.AreasService;

@CrossOrigin
@RestController
@RequestMapping("/api/area")
public class AreasController {
	@Autowired private AreasService mService;
	

    @PostMapping
    public ResponseEntity<?> saveAreas(@RequestBody AreasDTO dto){
    	System.out.println(dto);
        mService.save(dto);
        return ResponseEntity.ok().body("Areas saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(mService.listall());
    }
    
    @GetMapping("todays")
    public ResponseEntity<?> todayAreas(){
        return ResponseEntity.ok(mService.todayAreas());
    }
    
    @GetMapping("search")
    public ResponseEntity<?> searchAreas(SearchDTO dto){
        return ResponseEntity.ok(mService.searchAreas(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePark(@PathVariable("id") int id){
        mService.deleteAreas(id);
        return ResponseEntity.ok("areas deleted successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(mService.findById(id));
    }
}
