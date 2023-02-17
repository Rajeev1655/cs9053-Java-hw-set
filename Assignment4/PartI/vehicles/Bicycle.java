package vehicles;

public class Bicycle extends Vehicle{
    private boolean isElectric;
    
    public Bicycle(int wheel, int cargo, boolean isElectric) {
        super(wheel, cargo);
        this.isElectric = isElectric;
    }

    public Bicycle(boolean isElectric) {
        super(2,0);
        this.isElectric = isElectric;
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
        res += "Class: Bicycle" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " isElectric: " + this.isElectric;
        return res;
    }
}
