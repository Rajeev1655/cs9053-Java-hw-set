class WireCapacitance {

	
	public static void main(String[] arguments) {
		double absolutePermittivity = 8.85E-12;
		double initialDistance = .01;
		double finalDistance = .005;
		double wireLength = 0.5;
		double wireRadius = .002053;
		double capacitanceDifference = 0;

		double cap1 = calculate(absolutePermittivity, wireLength, wireRadius, initialDistance);
		double cap2 = calculate(absolutePermittivity, wireLength, wireRadius, finalDistance);
		capacitanceDifference = Math.abs(cap1 - cap2);

		 System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  + initialDistance +
		" m to " + finalDistance + "m is " + capacitanceDifference + " farads");
	}

	private static double calculate(double abs, double length, double radius, double dis) {
		return Math.PI * abs * length / Math.log(dis/2*radius + Math.sqrt((dis*dis/(4*radius*radius)) - 1));
	}
}