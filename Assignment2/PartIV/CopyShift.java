import java.lang.reflect.Array;

public class CopyShift {

	public static void copyShift(int[] sourceArray, int[] destArray, int shift) {
		if (shift < 0) {
			return;
		}else if (shift > sourceArray.length) {
			shift = shift % sourceArray.length;
		}

		System.arraycopy(sourceArray, sourceArray.length - shift, destArray, 0, shift);
		System.arraycopy(sourceArray, 0, destArray, shift, sourceArray.length - shift);

		System.out.println("shift: " + shift+ "\nsourceArray: " + printRes(sourceArray) + "\n"+ "destArray: " + printRes(destArray));
	}

	public static String printRes(int[] arr) {
		StringBuilder string = new StringBuilder();
		for (int i:arr) {
			string.append(i).append(" ");
		}
		return string.toString();
	}
	
	public static void main(String[] args) {
		
		int[] sourceArray = new int[50];
		int[] destArray = new int[50];
		
		/* initialize the source Array */
		for (int i = 0;i < sourceArray.length; i++) {
			sourceArray[i] = (int)(Math.random()*100);
		}
		
		int shiftValue = 3003;
		copyShift(sourceArray, destArray, shiftValue);
		
		/* destArray should have the contents of sourceArray
		 * but in shifted over "shiftValue" values
		 * if sourceArray has the contents [1,5,6,7,9] and we want to shift it 
		 * 3 spaces over, destArray should have the contents [6,7,9,1,5].
		 * 
		 * It should work for arbitrarily large values of shift
		 */
	}
}
