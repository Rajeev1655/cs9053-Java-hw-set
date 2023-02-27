package vehicles;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Employee objects
		// note-- do not use this particular class for anything. the intent
		// is to use this main method to write some scratch code.

		try{
			// Car
			Car car1 = new Car(10, 4, "red");
			System.out.println(car1.toString());
			System.out.println("id: " + car1.getID() + " " + car1.PressGasPadal() + "\n");
			
			// Motorcycle
			String[] a = {"helmet clip", "grip warmers", "usb charger"};
			Motorcycle motorcycle1 = new Motorcycle(a, "blue");
			System.out.println(motorcycle1.toString());
			System.out.println("id: " + motorcycle1.getID() + " " + motorcycle1.TwistThrottle() + "\n");

			// Bicycle
			Bicycle bicycle1 = new Bicycle("pink", false);
			System.out.println(bicycle1.toString());
			System.out.println("id: " + bicycle1.getID() + " " + bicycle1.Pedal() + "\n");

			// Cargocycle
			Cargocycle cargocycle1 = new Cargocycle(3, -20, "green", true);
			System.out.println(cargocycle1.toString());
			System.out.println("id: " + cargocycle1.getID() + " " + cargocycle1.Pedal() + "\n");

			// equals
			System.out.println("car1.equals(motorcycle1): " + car1.equals(motorcycle1));
			System.out.println("car1.equals(bicycle1): " + car1.equals(bicycle1));
			System.out.println("car1.equals(cargocycle1): " + car1.equals(cargocycle1));
			System.out.println("car1.equals(car1): " + car1.equals(car1));
			System.out.println("motorcycle1.equals(bicycle1): " + motorcycle1.equals(bicycle1));
			System.out.println("motorcycle1.equals(cargocycle1): " + motorcycle1.equals(cargocycle1));
			System.out.println("motorcycle1.equals(motorcycle1): " + motorcycle1.equals(motorcycle1));
			System.out.println("bicycle1.equals(cargocycle1): " + bicycle1.equals(cargocycle1));
			System.out.println("bicycle1.equals(bicycle1): " + bicycle1.equals(bicycle1));
			System.out.println("cargocycle1.equals(cargocycle1): " + cargocycle1.equals(cargocycle1));
		}catch(Exception e) {
			System.out.println(e);
		}	
	}
}
