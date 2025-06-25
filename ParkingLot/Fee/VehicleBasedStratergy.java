package ParkingLot.Fee;

import java.util.Map;

import ParkingLot.Ticket;
import ParkingLot.VehicleType.VehicleType;

public class VehicleBasedStratergy implements FeeStratergy {

    Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 30.0

    );

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();

        double fees = (duration / (1000 * 60 * 60) + 1) * hourlyRates.get(ticket.getVehicle().getVehicleType());
        return fees;
    }

}