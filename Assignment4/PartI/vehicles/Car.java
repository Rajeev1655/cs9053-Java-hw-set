package vehicles;

public class Car extends Vehicle{
    private int doors;
    
    public Car(int cargo, int door) {
        super(4, cargo);
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
        res += "Class: Car" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " Doors: " + this.doors;
        return res;
    }
}
