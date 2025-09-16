package com.parking.dtos;

import java.time.LocalDate;

public class SearchDTO {

	private int slot;
	private int hallId;
	private String parkName;
	private LocalDate date;
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "SearchDTO [slot=" + slot + ", hallId=" + hallId + ", parkName=" + parkName + ", date=" + date + "]";
	}	
	
	
}
