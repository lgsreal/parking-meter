package br.com.lgsreal.parkingmeter.repository;

import br.com.lgsreal.parkingmeter.entities.ParkingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingRecord, Long> {
}
