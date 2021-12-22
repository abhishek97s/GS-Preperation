package com.gs.medium;

import java.util.HashMap;

//find the length of minimum subarray exceeding sum
public class SubArrayExceedsSum
{
	public static int subArrayExceedsSum(int A[], int sum )
	{
        // stores the current window sum
        int windowSum = 0;
 
        // stores the result
        int len = Integer.MAX_VALUE;
 
        // stores the window's starting index
        int left = 0;
 
        // maintain a sliding window `[left…right]`
        for (int right = 0; right < A.length; right++)
        {
            // include the current element in the window
            windowSum += A[right];
 
            // the window becomes unstable if its sum becomes more than `k`
            while (windowSum > sum && left <= right)
            {
                // update the result if the current window's length is less than the
                // minimum found so far
                len = Integer.min(len, right - left + 1);
 
                // remove elements from the window's left side till the window
                // becomes stable again
                windowSum -= A[left];
                left++;
            }
        }
 
        // invalid input
        if (len == Integer.MAX_VALUE) {
            return 0;
        }
 
        // return result
        return len;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String[] args)
	{
		boolean result = true; 
		int[] arr = { 11, 2, 3, 4 };
		result = result && subArrayExceedsSum( arr, 6 ) == 1;
		result = result && subArrayExceedsSum( arr, 12 ) == 2;

		if( result )
		{
			System.out.println("All tests pass\n");
		}
		else
		{
			System.out.println("There are test failures\n");
		}
	}
};