
import java.io.*;
import java.util.*;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class Solution {
  
  static String input = "cat dog tac sat tas god dog";
  
  static void setOfAnagrams(String inputString){ 
    
    //your code goes here
	HashMap<String, ArrayList<String>>  ana = new HashMap<String, ArrayList<String>>();
	String[] words = input.split(" ");
	for(String w : words) {
		char[] wArr = w.toCharArray();
		Arrays.sort(wArr);
		String wSorted = new String(wArr);
		if(ana.containsKey(wSorted)) {
		}
		else {
			ana.put(wSorted, new ArrayList<String>());
		}
		ana.get(wSorted).add(w);
	}
	for(String s: ana.keySet()) {
		if(ana.get(s).size() > 1) {
			for(String word: ana.get(s)) {
				System.out.print(word + " ");
			}
		}
	} 
  }
  
  
  public static void main(String[] args) {
    
    String input = "cat dog tac sat tas god dog";
    setOfAnagrams(input);
    
  }
}