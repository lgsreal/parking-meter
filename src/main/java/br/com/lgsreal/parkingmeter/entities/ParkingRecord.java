package br.com.lgsreal.parkingmeter.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "parking_record")
public class ParkingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehiclePlate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double fee;

    public ParkingRecord(Long id, String vehiclePlate, LocalDateTime startTime, LocalDateTime endTime, double fee) {
        this.id = id;
        this.vehiclePlate = vehiclePlate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fee = fee;
    }

    public ParkingRecord() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingRecord that = (ParkingRecord) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ParkingRecord{" +
                "id=" + id +
                ", vehiclePlate='" + vehiclePlate + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", fee=" + fee +
                '}';
    }
}
