package com.parking.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dtos.SearchDTO;
import com.parking.dtos.AreasDTO;
import com.parking.models.Areas;
import com.parking.repos.AreasRepository;

@Service
public class AreasService {

	@Autowired private AreasRepository repo; 
	@Autowired private ParkService mservice;
	@Autowired private ParkingAreaService hservice;
	@Autowired private SearchSpecification ssp;
	
	public void save(AreasDTO dto) {
		Areas areas=new Areas();
		BeanUtils.copyProperties(dto, areas);
		areas.setHall(hservice.findById(dto.getHallId()));
		areas.setPark(mservice.findById(dto.getParkId()));
		repo.save(areas);
	}
	
	public List<Areas> listall(){
		return repo.findAll();
	}
	
	public List<Areas> todayAreas(){
		return repo.todaysShow();
	}
	
	public List<Areas> searchAreas(SearchDTO dto){
		return repo.findAll(ssp.getfilteredShows(dto));
	}
	
	public Areas findById(int id) {
		return repo.getById(id);
	}
	
	public void deleteAreas(int id) {
		repo.delete(repo.getById(id));
	}
}
