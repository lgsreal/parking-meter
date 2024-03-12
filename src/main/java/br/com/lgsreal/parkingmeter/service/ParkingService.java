package br.com.lgsreal.parkingmeter.service;

import br.com.lgsreal.parkingmeter.entities.ParkingRecord;
import br.com.lgsreal.parkingmeter.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ParkingService {
   private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public ParkingRecord startParking(String vehiclePlate) {
        ParkingRecord record = new ParkingRecord();
        record.setVehiclePlate(vehiclePlate);
        record.setStartTime(LocalDateTime.now());
        return parkingRepository.save(record);
    }

    public ParkingRecord endParking(Long id) {
        ParkingRecord record = parkingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid parking id"));
        record.setEndTime(LocalDateTime.now());
        long duration = Duration.between(record.getStartTime(), record.getEndTime()).toMinutes();
        record.setFee(calculateAmountDue(duration));
        return parkingRepository.save(record);
    }

    private double calculateAmountDue(long durationInMinutes) {
        return durationInMinutes * 0.1;
    }
}
