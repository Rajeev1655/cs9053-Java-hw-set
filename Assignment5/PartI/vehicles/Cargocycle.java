package vehicles;

public class Cargocycle extends Bicycle{

    public Cargocycle(int wheels, int cargo, String color, boolean isElectric)  throws VehicleException{
        super(wheels, cargo, color, isElectric);
    }

    public Cargocycle(){super();}

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
        res += "Class: Cargocycle" + " Wheels: " + super.getWheels() + " Cargo: " + super.getCargoSpace() + " Color: " +
                this.getColor() + " isElectric: " + super.getIsElectric();
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            if(obj instanceof Cargocycle) {
                return true;
            }
        }
        return false;
    }
}
