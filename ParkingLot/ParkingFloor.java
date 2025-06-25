package ParkingLot;

import java.util.List;
import java.util.Optional;

import ParkingLot.VehicleType.VehicleType;

public class ParkingFloor {
    public final int floorNumber;
    public List<ParkingSpot> parkingSpot;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpot = parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType type) {
        return parkingSpot.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType() == type)
                .findFirst();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpot;
    }

    public List<Integer> getAllAvailableSpots(VehicleType vehicleType) {
        return parkingSpot.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType() == vehicleType)
                .map(ParkingSpot::getSpotNumber)
                .toList();
    }
}
