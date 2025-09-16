package com.parking.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Areas")
public class Areas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="areaId")
	private int showId;
	@ManyToOne
	@JoinColumn(name = "parkin_area_id")
	private ParkingArea hall;
	@ManyToOne
	@JoinColumn(name = "park_id")
	private Park park;
	private int slot;
	private int price;
	private LocalDate fromDate;
	private LocalDate toDate;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public ParkingArea getHall() {
		return hall;
	}
	public void setHall(ParkingArea hall) {
		this.hall = hall;
	}
	
	public Park getPark() {
		return park;
	}
	public void setPark(Park park) {
		this.park = park;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	
}
