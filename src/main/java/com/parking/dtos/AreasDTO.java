package com.parking.dtos;

import com.parking.models.Areas;

public class AreasDTO extends Areas {

	private int hallId;
	private int parkId;
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	@Override
	public String toString() {
		return "ShowDTO [hallId=" + hallId + ", parkId=" + parkId + "]";
	}
	
	
}
