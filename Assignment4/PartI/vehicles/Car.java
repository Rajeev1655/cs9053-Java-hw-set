package vehicles;

public class Car extends Vehicle{
    private int doors;
    
    public Car(int cargo, int door, String color) {
        super(4, cargo, color);
        this.doors = door;
    }

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
