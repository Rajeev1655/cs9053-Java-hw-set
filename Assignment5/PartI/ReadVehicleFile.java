import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import vehicles.*;

/* your tasks:
 * create a class called VehicleException
 * createVehicle should throw a VehicleException
 * in main(), you should catch the VehicleException
 *
 */
public class ReadVehicleFile {

	public static Vehicle createVehicle(String vehicleName) throws VehicleException{

		/* if vehicleName is "Motorcycle" return Motorcycle();
		 * if vehicleName is "Car" return Car();
		 * if vehicleName is "Bicycle" return Bicycle();
		 * if vehicleName is "CargoCycle" return CargoCycle();
		 * if it is not any one of these, it should throw
		 * a VehicleException
		 */
        switch (vehicleName){
            case "Motorcycle":
                return new Motorcycle();
            case "Car":
                return new Car();
            case "Bicycle":
                return new Bicycle();
            case "CargoCycle":
                return new Cargocycle();
            default:
                throw new VehicleException("NOT a Vehicle");
        }
    }

	public static void main(String[] args) {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

		File f = new File("./vehicles.txt");
		String inString = null;

		/* create a loop to read the file line-by-line */
		try {
			Scanner scanner = new Scanner(f);
			while (scanner.hasNext()) {
				inString = scanner.nextLine();
				try {
					Vehicle vehicle = createVehicle(inString);
					vehicleList.add(vehicle);
				} catch (VehicleException e) {
					System.err.println("Cannot create Vehicle: " + inString);
				}
			}
		}catch (Exception e){
			System.out.println(e.toString());
		}

		System.out.println(vehicleList);

	}
}
