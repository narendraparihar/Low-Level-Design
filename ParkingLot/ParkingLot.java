package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import ParkingLot.Fee.FeeStratergy;
import ParkingLot.Fee.FlatFeeStratergy;
import ParkingLot.VehicleType.Vehicle;
import ParkingLot.VehicleType.VehicleType;

public class ParkingLot {

    public List<ParkingFloor> floors;
    private FeeStratergy feeStratergy;
    private static ParkingLot instance;
    private final Map<String, Ticket> activeTicket = new ConcurrentHashMap<>();

    ParkingLot() {
        floors = new ArrayList();
        feeStratergy = new FlatFeeStratergy();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle.getVehicleType());
            if (spotOpt.isPresent()) {
                ParkingSpot spot = spotOpt.get();
                if (spot.park(vehicle)) {
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, vehicle, spot);
                    activeTicket.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("parking spots not Available for" + vehicle.getVehicleType());
    }

    public void addFloor(ParkingFloor parkingFloor) {
        floors.add(parkingFloor);
    }

    public List<ParkingFloor> getParkingFloor() {
        return floors;
    }

    public synchronized double unparkVehicle(String ticketId) throws Exception {
        Ticket ticket = activeTicket.remove(ticketId);
        if (ticket == null)
            throw new Exception("Invalid ticket");

        ParkingSpot spot = ticket.getSpot();
        spot.unpark();

        ticket.setExitTimestamp();
        return feeStratergy.calculateFee(ticket);
    }

    public void setFeeStratergy(FeeStratergy feeStratergy) {
        this.feeStratergy = feeStratergy;
    }

}