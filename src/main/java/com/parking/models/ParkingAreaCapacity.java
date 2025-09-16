package com.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ParkingAreaCapacity")
public class ParkingAreaCapacity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "hall_id")
	@JsonBackReference
	private ParkingArea hall;
	@ManyToOne
	@JoinColumn(name = "seat_type_id")
	private SeatType seatType;
	private int seatCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ParkingArea getHall() {
		return hall;
	}
	public void setHall(ParkingArea hall) {
		this.hall = hall;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	
	
	
}
