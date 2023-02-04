import java.util.Scanner;

public class BoxingWeightClass {

	public static String findWeightClass(float weight) {
		// this is really only valid for weights greater than 0.
		String res = "";
		if (weight <= 108){
			res = "light flyweight";
		}else if(108 < weight && weight <= 115){
			res = "flyweight";
		}else if(115 < weight && weight <= 123){
			res = "bantamweight";
		}else if(123 < weight && weight <= 132){
			res = "lightweight";
		}else if(132 < weight && weight <= 141){
			res = "light welterweight";
		}else if(141 < weight && weight <= 152){
			res = "welterweight";
		}else if(152 < weight && weight <= 165){
			res = "middleweight";
		}else if(165 < weight && weight <= 178){
			res = "Light heavyweight";
		}else if(178 < weight && weight <= 201){
			res = "Heavyweight";
		}else if(201 < weight){
			res = "Super heavyweight";
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * income using Scanner because you will have to convert
		 * a command line argument to an float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "weight" variable
		 * to whatever you want in the code, and that's fine too
		 */
		System.out.println("Please enter weight:");
		Scanner scanner = new Scanner(System.in);
		float weight = 0;
		try {
			weight = scanner.nextFloat();
		}
		catch (Exception e){
			System.out.println("Please enter a digit.");
			return;
		}

		if (weight <= 0) {
			System.out.println("Input has to be larger than 0.");
			return;
		}
		
		String weightClass = findWeightClass(weight);
		
		// if the digits are greater than zero print this out:
		System.out.println("The weight class for the weight " + weight + " is " 
		+ weightClass);
	}
}
