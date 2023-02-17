package vehicles;

import java.util.Objects;

public class Bicycle extends Vehicle{
    private boolean isElectric;
    
    public Bicycle(int wheel, int cargo, String Color, boolean isElectric) {
        super(wheel, cargo, Color);
        this.isElectric = isElectric;
    }

    public Bicycle(String color, boolean isElectric) {
        super(2,0, color);
        this.isElectric = isElectric;
    }

    public Bicycle() {
        super();
    }

    public void setIsElectric(boolean b) {
        this.isElectric = b;
    }
    
    public boolean getIsElectric() {
        return this.isElectric;
    }

    public String Pedal() {
        return "pedaling";
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String toString() {
        String res = "";
        res = "Superclass: { " + super.toString() + " }\n";
        res += "Class: Bicycle" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " Color: " +
                this.getColor() + " isElectric: " + this.isElectric;
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) obj;
            if (super.equals(bicycle)) {
                if(this.isElectric==bicycle.isElectric) {
                    return true;
                }
            }
        }
        return false;
    }

}
