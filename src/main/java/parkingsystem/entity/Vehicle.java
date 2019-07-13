package parkingsystem.entity;


public class Vehicle
{

    String vehicleModel;
    String plateNumber;
    VehicleSize vehicleSize;


    public Vehicle( String vehicleModel, String plateNumber, VehicleSize vehicleSize )
    {
        this.vehicleModel = vehicleModel;
        this.plateNumber = plateNumber;
        this.vehicleSize = vehicleSize;
    }
}
