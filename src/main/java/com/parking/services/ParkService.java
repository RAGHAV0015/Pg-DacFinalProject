package com.parking.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.parking.dtos.ParkDTO;
import com.parking.models.Park;
import com.parking.repos.ParkRepository;
import com.parking.utils.StorageService;

@Service
public class ParkService {

	@Autowired private ParkRepository repo;
	@Autowired private StorageService storage;
	
	public void save(Park park,MultipartFile photo) {
		System.out.println("park id"+park.getParkId());
		if(park.getParkId()==0) {
			String poster=storage.store(photo);
			park.setPoster(poster);
		}else {
			if(photo!=null) {
				String poster=storage.store(photo);
				park.setPoster(poster);				
			}else {
				Park mm=repo.findById(park.getParkId()).get();
				park.setPoster(mm.getPoster());
			}
		}
		repo.save(park);
	}
	
	public List<Park> listall(){
		return repo.findAll();
	}
	
	public Park findById(int id) {
		return repo.getById(id);
	}
	
	public void deletePark(int id) {
		repo.delete(repo.getById(id));
	}
}
