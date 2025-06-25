package ParkingLot.VehicleType;

public abstract class Vehicle {
    protected VehicleType vehicleType;
    protected String licencePlate;

    public Vehicle(VehicleType vehicleType, String licencePlate) {
        this.vehicleType = vehicleType;
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
