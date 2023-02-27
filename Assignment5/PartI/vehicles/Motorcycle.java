package vehicles;

import java.util.Arrays;

public class Motorcycle extends Vehicle{
    private String[] accessories;

    public Motorcycle(String[] accList, String color)  throws VehicleException{
        super(2, 0, color);
        this.accessories = accList;
    }

    public Motorcycle(){
        super();
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
        res += "Class: Motorcycle" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " Color: " +
                this.getColor() + " accessories: " + Arrays.toString(this.accessories);
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            if(obj instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) obj;
                if(this.accessories==motorcycle.accessories) {
                    return true;
                }
            }
        }
        return false;
    }
}
