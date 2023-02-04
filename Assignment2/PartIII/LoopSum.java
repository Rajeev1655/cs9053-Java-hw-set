import java.text.DecimalFormat;
import java.util.HashMap;

public class LoopSum {

	
	public static void estimateExponential() {
		int z, x;
		double curRes, preRes;
		// use HashMap to improve performance
		HashMap<Integer, Double> factorialMap = new HashMap<>();
		factorialMap.put(1, (double) 1);
		factorialMap.put(0, (double) 1);
		HashMap<Integer, Double> powerMap = new HashMap<>();

		// estimate power z from 0 to 15
		for (z = 0; z <= 15; z ++){
			x = 0;
			curRes = 0.f;
			preRes = 0.f;
			powerMap.put(0, (double) 1);
			powerMap.put(1, (double) z);

			// loop until the last 3 decimal is stabled
			while(!is3decimal(curRes, preRes)) {
				preRes = curRes;
				curRes = preRes + power(powerMap, x, z) / factorial(factorialMap, x);
				x++;
			}

			printResult(z, x - 1, curRes);
			powerMap.clear();
		}

	}
	public static boolean is3decimal(double a, double b) {
		if (a == 0.f && b == 0.f) {
			return false;
		}
		// compare if two double are same within .001, with rounding
		return String.format("%.3f", a).equals(String.format("%.3f", b));
//		DecimalFormat df = new DecimalFormat("#.000");
//		return df.format(a).equals(df.format(b));
	}

	public static double factorial(HashMap<Integer, Double> map, int n) {
		if (!map.containsKey(n)) {
			map.put(n, map.get(map.size() - 1) * (double) n);
		}
		return map.get(n);
	}

	public static double power(HashMap<Integer, Double> map, int n, int z) {
		if (!map.containsKey(n)) {
			map.put(n, map.get(map.size() - 1) * (double) z);
		}
		return map.get(n);
	}

	public static void printResult(int z, int x, double res){
		System.out.println("e^" + z + " is " + Math.pow(Math.E, z));
		System.out.println("result for " + x + " iterations: " + res);
		System.out.println("it requires " + x + " iterations to estimate e^" + z + " within .001 \n");
	}
	
	public static void main(String[] args) {
		estimateExponential();
	}
	
}
