package vehicles;

import java.util.Arrays;

public class Motorcycle extends Vehicle{
    private String[] accessories;

    public Motorcycle(String[] accList) {
        super(2, 0);
        this.accessories = accList;
    }

    public void setAccessories(String[] accList) {
        this.accessories = accList;
    }

    public String[] getAccessories() {
        return this.accessories;
    }

    public String TwistThrottle() {
        return "accelerating";
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String toString() {
        String res = "";
        res = "Superclass: { " + super.toString() + " }\n";
        res += "Class: Motorcycle" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " accessories: " + Arrays.toString(this.accessories);
        return res;
    }
}
