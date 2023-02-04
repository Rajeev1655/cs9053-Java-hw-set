import java.util.LinkedList;

/**
 * I implement the algorithm to find continuous subarray whose sum can
 * reach the goal.
 * If subarray is non-continuous, just sort the array and look for a
 * sum that reach the goal.
 * */
class FindMinimumLength {
    public static int minSubArrayLen(int goal, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minimumLength = Integer.MAX_VALUE, curLength = 0;
        int leftPtr = 0, rightPtr = 1;
        int sum = nums[leftPtr];

        // double pointer
        while (leftPtr < nums.length) {
            if (sum >= goal) {
                curLength = rightPtr - leftPtr;
                minimumLength = Math.min(minimumLength, curLength);
                sum -= nums[leftPtr];
                leftPtr++;
            }else if (rightPtr == nums.length){
                leftPtr++;
            }else {
                sum += nums[rightPtr];
                rightPtr++;
            }
        }

        return Math.min(minimumLength, curLength);
    }
    
    public static void main(String[] args) {
    	int[] array1 =   {10,2,3,11};
    	System.out.println(minSubArrayLen(11, array1));
    	int[] array2 =   {5, 6, 8, 2};
    	System.out.println(minSubArrayLen(7, array2));
    }
}
