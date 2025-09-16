package com.parking.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ParkingArea")
public class ParkingArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parkingAreaId")
	private int hallId;
	@Column(name="parkingAreaDesc")
	private String hallDesc;
	private int capacity;
	@OneToMany	
	@Column(name="parkingAreaCapacity")
	private List<ParkingAreaCapacity> hallcapacity;
	
	public List<ParkingAreaCapacity> getHallcapacity() {
		return hallcapacity;
	}
	public void setHallcapacity(List<ParkingAreaCapacity> hallcapacity) {
		this.hallcapacity = hallcapacity;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getHallDesc() {
		return hallDesc;
	}
	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
