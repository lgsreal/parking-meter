package br.com.lgsreal.parkingmeter.controller;

import br.com.lgsreal.parkingmeter.entities.ApiResponse;
import br.com.lgsreal.parkingmeter.entities.ParkingRecord;
import br.com.lgsreal.parkingmeter.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {
    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/start")
    public ApiResponse<ParkingRecord> startParking(@RequestParam String vehiclePlate) {
        ParkingRecord record = parkingService.startParking(vehiclePlate);
        return new ApiResponse<>("Parking started successfully", record);
    }

    @PostMapping("/end/{id}")
    public ApiResponse<ParkingRecord> endParking(@PathVariable Long id) {
        ParkingRecord record = parkingService.endParking(id);
        return new ApiResponse<>("Parking ended successfully", record);
    }
}
