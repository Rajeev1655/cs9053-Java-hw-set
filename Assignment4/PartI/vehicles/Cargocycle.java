package vehicles;

public class Cargocycle extends Bicycle{

    public Cargocycle(int wheels, int cargo, boolean isElectric) {
        super(wheels, cargo, isElectric);
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String Pedal() {
        return "pedaling";
    }

    @Override
    public String toString() {
        String res = "";
        res = "Superclass: { " + super.toString() + " }\n";
        res += "Class: Cargocycle" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " isElectric: " + super.getIsElectric();
        return res;
    }
}
