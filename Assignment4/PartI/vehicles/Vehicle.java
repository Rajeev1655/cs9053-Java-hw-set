package vehicles;

public class Vehicle {
    private int wheels;
    private int cargoSpace;
    private String color;
    private int id;
    private static int next_id;

    public Vehicle(int wheels, int carge) {
        this.wheels = wheels;
        this.cargoSpace = carge;
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

    public String toString() {
        return "id: " + this.id + "Class: Vehical" + " Wheels: " + this.wheels + " Cargo: " + this.cargoSpace;
    }

    public boolean equals(Object obj) {
		if(super.equals(obj)) {
            boolean isEqual = true;
			if(obj instanceof Vehicle) {
				Vehicle vehicle=(Vehicle)obj;
				if(this.wheels!=vehicle.getWheels()) {
					isEqual = false;
				}else if(this.cargoSpace!= vehicle.getCargoSpace()) {
                    isEqual = false;
                }else if(this.color!=vehicle.getColor()) {
                    isEqual = false;
                }
                return isEqual;
			}
		}
		return false;
	}
}