package ParkingLot;

import ParkingLot.VehicleType.Vehicle;
import ParkingLot.VehicleType.VehicleType;

public class ParkingSpot {
    private final VehicleType vehicleType;
    private final int spotNumber;
    private Vehicle vehicle;
    private boolean isOccupied;

    ParkingSpot(VehicleType vehicleType, int spotNumber) {
        this.vehicleType = vehicleType;
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean park(Vehicle vehicle) {
        if (isOccupied || vehicle.getVehicleType() != vehicleType) {
            return false;
        }

        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public synchronized void unpark() {
        vehicle = null;
        isOccupied = false;
    }

    public int getSpotNumber() {
        return this.spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
