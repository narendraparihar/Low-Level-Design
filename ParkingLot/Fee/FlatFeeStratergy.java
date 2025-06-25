package ParkingLot.Fee;

import ParkingLot.Ticket;

public class FlatFeeStratergy implements FeeStratergy {

    public static double RATE_PER_HOUR = 20.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();

        double fees = ((duration / (1000 * 60 * 60)) + 1) * RATE_PER_HOUR;
        return fees;
    }
}
