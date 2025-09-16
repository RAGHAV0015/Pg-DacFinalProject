package com.parking.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.parking.models.Park;

public class ParkDTO extends Park {

	private MultipartFile photo;

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
}
