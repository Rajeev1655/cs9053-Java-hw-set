package vehicles;

public class Car extends Vehicle{
    private int doors;
    
    public Car(int cargo, int door, String color) throws VehicleException{
        super(4, cargo, color);
        if (door < 2) {
            throw new VehicleException("Car can not have less than 2 doors. Trying to create car id:" + getNextId());
        }else {
            this.doors = door;
        }
        
    }

    public Car(){super();};

    public void setDoors(int n) {
        this.doors = n;
    }
    
    public int getDoors() {
        return this.doors;
    }

    public String PressGasPadal() {
        return "accelareting";
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String toString() {
        String res = "";
        res = "Superclass: { " + super.toString() + " }\n";
        res += "Class: Car" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " Color: " +
                this.getColor() + " Doors: " + this.doors;
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car) {
            Car car = (Car) obj;
            if (super.equals(car)) {
                if (this.doors == car.doors) {
                    return true;
                }
            }
        }
        return false;
    }
}
