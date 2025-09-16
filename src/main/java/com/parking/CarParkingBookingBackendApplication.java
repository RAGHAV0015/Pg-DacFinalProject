package com.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.parking.utils.FileUploadProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class CarParkingBookingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkingBookingBackendApplication.class, args);
	}

}
