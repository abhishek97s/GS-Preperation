public class Solution {
	/**
	 * int secondSmallest(int[] x)
	 */
	public static int secondSmallest(int[] x) {
		// Your code
		
		//Java 8
		//return Arrays.stream(a).sorted().limit(2).max().orElse(0);
		
		//Java 7
		if(x.length < 1) {
			return 0;
		}
		if(x.length < 2) {
			return x[0];
		}
		int min = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
		for(int i = 0; i < x.length; i++) {
			if(x[i] <= min) {
				min1 = min;
				min = x[i];
			}
			else if(x[i] < min1) {
				min1 = x[i];
			}
		}
		return min1;
	}

	public static void main(String args[]) {

		int[] a = { 0 };
		int[] b = { 0, 1 };

		boolean result = true;
		result &= secondSmallest(a) == 0;
		result &= secondSmallest(b) == 1;

		if (result) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}
}