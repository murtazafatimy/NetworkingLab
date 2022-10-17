package edu.sdccd.cisc191;

import java.io.Serializable;
import java.util.Arrays;

public class VehicleResponse implements Serializable {
    private VehicleRequest request;
    private int milesOnVehicle;
    private int price;
    private int numberOfSeats;
    private int numberOfDoors;
    private String[] options;
    public String message;
    public VehicleResponse(VehicleRequest request, int milesOnVehicle, int price, int numberOfSeats, int numberOfDoors, String[] options){
        this.request = request;
        this.milesOnVehicle = milesOnVehicle;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.options = options;

        message = request.message + " This vehicle has " + milesOnVehicle + " miles, costs $" + price + ", " + numberOfSeats + " seats, " + numberOfDoors +
                " doors, and is available in the following options:\n" + Arrays.toString(options) + ".";
    }


}