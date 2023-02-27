package vehicles;

import java.util.Objects;

public class Vehicle {
    private int wheels;
    private int cargoSpace;
    private String color;
    private int id;
    private static int next_id;

    public Vehicle(int wheels, int cargo, String color) throws VehicleException{
        if (cargo < 0) {
            throw new VehicleException("CargoSpace can not be negative. Trying to create vehicle id:" + next_id);
        }else {
            this.wheels = wheels;
            this.cargoSpace = cargo;
            this.color = color;
            id = next_id;
            next_id++;
        }
    }

    public Vehicle() {
        this.wheels = 0;
        this.cargoSpace = 0;
        this.color = "";
        id = next_id;
        next_id++;
    }

    public void setWheels(int n) {
        this.wheels = n;
    }

    public int getWheels() {
        return this.wheels;
    }

    public void setCargoSpace(int n) {
        this.cargoSpace = n;
    }

    public int getCargoSpace() {
        return this.cargoSpace;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public int getID() {
        return this.id;
    }

    public static int getNextId() {
        return next_id;
    }

    public String toString() {
        return "id: " + this.id + " Class: Vehical" + " Wheels: " + this.wheels + " Cargo: " + this.cargoSpace
                + " Color: " + this.color ;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;
            if(this.wheels==vehicle.wheels && this.cargoSpace == vehicle.cargoSpace && this.color == vehicle.color) {
                return true;
            }
        }
		return false;
	}
}