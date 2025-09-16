package com.parking.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dtos.ParkingAreaCapacityDTO;
import com.parking.models.ParkingArea;
import com.parking.models.ParkingAreaCapacity;
import com.parking.repos.ParkingAreaCapacityRepository;
import com.parking.repos.ParkingAreaRepository;

@Service
public class ParkingAreaService {
	@Autowired private ParkingAreaRepository repo;
	@Autowired private ParkingAreaCapacityRepository hcrepo;
	@Autowired private SeatTypeService sservice;
	
	public void saveCapacity(ParkingAreaCapacityDTO dto) {
		ParkingAreaCapacity hc=new ParkingAreaCapacity();
		BeanUtils.copyProperties(dto, hc);
		hc.setSeatType(sservice.findById(dto.getSeatTypeId()));
		ParkingArea parkingArea=repo.getById(dto.getHallId());
		hc.setHall(parkingArea);
		
		ParkingAreaCapacity hcc= hcrepo.save(hc);
		List<ParkingAreaCapacity> hcs= parkingArea.getHallcapacity();
		hcs.add(hcc);
		parkingArea.setHallcapacity(hcs);
		repo.save(parkingArea);
	}
	
	public void deleteSeat(int id) {
		ParkingAreaCapacity hc=hcrepo.getById(id);
		ParkingArea parkingArea=hc.getHall();
		List<ParkingAreaCapacity> hcs= parkingArea.getHallcapacity();
		hcs.remove(hc);
		repo.save(parkingArea);
		hcrepo.delete(hc);
	}

	public void save(ParkingArea parkingArea) {
		repo.save(parkingArea);
	}

	public List<ParkingArea> listall(){
		return repo.findAll();
	}

	public ParkingArea findById(int id) {
		return repo.getById(id);
	}

	public void deleteParkingArea(int id) {
		repo.delete(repo.getById(id));
	}
}
