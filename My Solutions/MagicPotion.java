package com.gs.medium;

/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

 */

public class MagicPotion
{
	private static int minimalSteps( String ingredients )
	{
		int n = ingredients.length();
		if (n == 0) {
			return 0;
		}
		StringBuilder magicPotion = new StringBuilder();
		// add first character
		magicPotion.append(ingredients.charAt(0));
		int idx = 1;
		while ( idx < n ) {
			if (idx * 2 <= n 
					&& ingredients.substring(0, idx).equals(ingredients.substring(idx, 2 * idx))) {
				magicPotion.append("*");
				idx*= 2; // a -1 here as there is already a ++i in for loop
			} 
			else { // i*2 has crossed n, simply add the characters
				magicPotion.append(ingredients.charAt(idx));
				idx+= 1;
			}
		}
		System.out.println(ingredients + "\t" + magicPotion);

		return magicPotion.length();

	}

	public static void main(String[] args) {

		if (minimalSteps("ABABCABABCE") == 6 && minimalSteps("ABCABCE") == 5) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
