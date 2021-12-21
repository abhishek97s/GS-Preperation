package com.gs.medium;

public class CountLengthOfCycle {

	public static int countLengthOfCycle( int[] arr, int startIndex ) {
		if (arr == null || arr.length == 0 || arr[startIndex]>=arr.length)
			return -1;
        int count = 1;
		int fast = arr[arr[startIndex]];
		int slow = arr[startIndex];
	       while (fast != slow) {
			if (fast >= arr.length || arr[fast]>=arr.length)
				return -1;
			count++;
			fast = arr[arr[fast]];
			slow = arr[slow];
		}
	       System.out.println(count);
		return count;
	}


	public static void main( String[] args ) {

		boolean testsPassed = true;

		testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[]{1, 2, 0,0}, 0) == 3;

		if(testsPassed) {
			System.out.println( "Test passed." );
			//return true;
		} else {
			System.out.println( "Test failed." );
			//return false;
		}


	}
}
