package arraylists;
import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
		ArrayList<Vehicle> vehiclesArrayList = new ArrayList<Vehicle>();
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Motorcycle redMotorcycle = new Motorcycle(new String[] {"grip warmers", "usb charger"}, "red");
		Car blueCar = new Car(20, 4, "blue");
		Car blueCar2 = new Car(20, 4, "blue");
		Bicycle blankBicycle = new Bicycle();
		Cargocycle greenCargocycle = new Cargocycle(3, 10, "green", true);
		Cargocycle greenCargocycle2 = new Cargocycle(3, 10, "green", true);
		Car grayCar = new Car(10, 2, "gray");
		Car whiteCar = new Car(25, 4, "white");

		vehiclesArrayList.add(redMotorcycle);
		vehiclesArrayList.add(blueCar);
		vehiclesArrayList.add(blueCar2);
		vehiclesArrayList.add(blankBicycle);
		vehiclesArrayList.add(greenCargocycle);
		vehiclesArrayList.add(greenCargocycle2);
		vehiclesArrayList.add(grayCar);
		vehiclesArrayList.add(whiteCar);


		// print out average cargoSpace of all Cars in the arraylist
		int cargoSpaceSum = 0;
		int carCount = 0;
		for (Vehicle v : vehiclesArrayList) {
			if (v instanceof Car) {
				carCount++;
				cargoSpaceSum += ((Car) v).getCargoSpace();
			}
		}
		System.out.println(ANSI_YELLOW + "******** Average cargo space of all cars: " + ANSI_RESET + (double) cargoSpaceSum / carCount);


		// remove blue car but retain the first one
		System.out.println(ANSI_YELLOW + "\n******** Removing blue car but retaining the first one:" + ANSI_RESET);
		boolean isBlueCarFound = false;
		for (int i = 0; i < vehiclesArrayList.size(); i++) {
			if (vehiclesArrayList.get(i) instanceof Car) {
				Car v = (Car) vehiclesArrayList.get(i);
				if (v.equals(blueCar)) {
					if (isBlueCarFound) {
						System.out.println("Removed " + v.toString() + " ****index in array: " + i);
						vehiclesArrayList.remove(i);
						i++; // need to reduce i by 1 since the arraylist has been shortened
					} else {
						isBlueCarFound = true;
					}
				}
			}
		}

		// print out the remaining objects in the arraylist
		System.out.println(ANSI_YELLOW + "\n******** Remaining objects in the arraylist: " + ANSI_RESET);
		for (Vehicle v : vehiclesArrayList) {
			System.out.println(v.toString() + "\n");
		}
	}

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
}
