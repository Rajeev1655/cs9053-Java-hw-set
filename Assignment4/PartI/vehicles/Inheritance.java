package vehicles;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Employee objects
		// note-- do not use this particular class for anything. the intent
		// is to use this main method to write some scratch code.

		// Car
		Car car1 = new Car(10, 4);
		System.out.println(car1.toString());
		System.out.println("id: " + car1.getID() + " " + car1.PressGasPadal() + "\n");
		
		// Motorcycle
		String[] a = {"helmet clip", "grip warmers", "usb charger"};
		Motorcycle motorcycle1 = new Motorcycle(a);
		System.out.println(motorcycle1.toString());
		System.out.println("id: " + motorcycle1.getID() + " " + motorcycle1.TwistThrottle() + "\n");

		// Bicycle
		Bicycle bicycle1 = new Bicycle(false);
		System.out.println(bicycle1.toString());
		System.out.println("id: " + bicycle1.getID() + " " + bicycle1.Pedal() + "\n");

		// Cargocycle
		Cargocycle cargocycle1 = new Cargocycle(3, 20, true);
		System.out.println(cargocycle1.toString());
		System.out.println("id: " + cargocycle1.getID() + " " + cargocycle1.Pedal() + "\n");

		// equals
		
	}
}
