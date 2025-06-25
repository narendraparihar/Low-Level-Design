package ParkingLot;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.Fee.VehicleBasedStratergy;
import ParkingLot.VehicleType.*;

public class ParkingLotDemo {
    public static void main(String[] args) {
        System.out.println("Parking Lot Demo ");
        run();
    }

    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        List<ParkingSpot> parkingFloor1 = List.of(
                new ParkingSpot(VehicleType.CAR, 101),
                new ParkingSpot(VehicleType.BIKE, 102),
                new ParkingSpot(VehicleType.CAR, 103));

        List<ParkingSpot> parkingFloor2 = List.of(
                new ParkingSpot(VehicleType.TRUCK, 201),
                new ParkingSpot(VehicleType.CAR, 202));

        ParkingFloor floor1 = new ParkingFloor(1, parkingFloor1);
        ParkingFloor floor2 = new ParkingFloor(2, parkingFloor2);
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setFeeStratergy(new VehicleBasedStratergy());

        Vehicle car1 = new Car("AB01AA0000");
        Vehicle car2 = new Car("WB01EE0001");
        Vehicle bike1 = new Bike("WB01EE0001");

        System.out.println("Available Parking spot for Car");
        for (ParkingFloor floor : parkingLot.getParkingFloor()) {
            System.out.println("Floor:" + floor.getFloorNumber() + " " + floor.getAvailableSpot(VehicleType.CAR));
        }

        List<String> parkingTickets = new ArrayList<>();
        try {
            Ticket ticket1 = parkingLot.parkVehicle(car1);
            System.out.println("Car 1 parked: " + ticket1.getTicketId());
            parkingTickets.add(ticket1.getTicketId());

            Ticket ticket2 = parkingLot.parkVehicle(car2);
            System.out.println("Car 2 parked: " + ticket2.getTicketId());
            parkingTickets.add(ticket2.getTicketId());

            Ticket ticket3 = parkingLot.parkVehicle(bike1);
            System.out.println("Bike 1 parked: " + ticket3.getTicketId());
            parkingTickets.add(ticket3.getTicketId());

            Vehicle car3 = new Car("DL0432");
            parkingLot.parkVehicle(car3);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            double fee = parkingLot.unparkVehicle(parkingTickets.getFirst());
            System.out.println("Ticket: " + parkingTickets.getFirst() + ", Fee: " + fee);

            fee = parkingLot.unparkVehicle("1");
        } catch (Exception e) {
            System.out.println("Exception while unparking: " + e.getMessage());
        }
    }

}
