
public class WireCapacitance {

	public static double calculateWireCapacitance(double l, double a, double d0, double d1) {
		double absolutePermittivity = 8.85E-12;

		double cap1 = calculate(absolutePermittivity, l, a, d0);
		double cap2 = calculate(absolutePermittivity, l, a, d1);
		
		return Math.abs(cap1 - cap2);
	}

	private static double calculate(double abs, double length, double radius, double dis) {
		return Math.PI * abs * length / Math.log(dis/2*radius + Math.sqrt((dis*dis/(4*radius*radius)) - 1));
	}
	
	public static void main(String[] args) {
		double l = 0.5; // wirelength
		double a = .002053; // wireRadius
		double d0 = .01; // initialDistance
		double d1 = .005; // finalDistance

		double result = calculateWireCapacitance(l, a, d0, d1);
		System.out.println(result);
	}
}
