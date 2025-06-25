package ParkingLot;

import java.util.Date;

import ParkingLot.VehicleType.Vehicle;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final long entryTime;
    private long exitTime;
    private final ParkingSpot parkingSpot;

    Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = new Date().getTime();
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public long getEntryTime() {
        return this.entryTime;
    }

    public long getExitTime() {
        return this.exitTime;
    }

    public ParkingSpot getSpot() {
        return parkingSpot;
    }

    public void setExitTimestamp() {
        this.exitTime = new Date().getTime();
    }

}
