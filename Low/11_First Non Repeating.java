package com.gs.practice;

import java.util.HashMap;

public class Low11FirstNotRepeating {

	  /**
	  * Finds the first character that does not repeat anywhere in the input string
	  * Given "apple", the answer is "a"
	  * Given "racecars", the answer is "e"
	  **/        
	  public static char findFirst(String input)
	  {
	    	HashMap <Character, Boolean> charMap = new HashMap<Character, Boolean>();
		for(int i = 0; i < input.length(); i++) {
			if(charMap.containsKey(input.charAt(i))) {
				charMap.replace(input.charAt(i), false);
			}
			else {
				charMap.put(input.charAt(i), true);
			}
		}
		for(int i = 0; i < input.length(); i++) {
			if(charMap.get(input.charAt(i))) {
				return input.charAt(i);
			}
			
		}
		return '0';
	  }

	  public static void main(String args[])
	  {

	    String[] inputs = {"apple","racecars", "ababdc"};
	    char[] outputs = {'a', 'e', 'd' };

	    boolean result = true;
	    for(int i = 0; i < inputs.length; i++ )
	    {
	      result = result && findFirst(inputs[i]) == outputs[i];
	      if(!result)
	        System.out.println("Test failed for: " + inputs[i]);
	      else
	        System.out.println("Test passed for: " + inputs[i]);
	    }
	  }

	}

