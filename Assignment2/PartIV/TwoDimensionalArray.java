
public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		/* copy arrayOne and arrayTwo into twoDimArray */
		System.arraycopy(arrayOne, 0, twoDimArray[0], 0, arrayOne.length);
		System.arraycopy(arrayTwo, 0, twoDimArray[1], 0, arrayTwo.length);

		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		for (int[] arr: twoDimArray) {
			for(int i: arr){
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
		
		/* the solution should use nested loops: one loop to loop over
		 * each array in twoDimArray, and one loop to loop over each element
		 * in that array
		 */
	}
}
