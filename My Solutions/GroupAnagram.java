
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.function.*;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

public class Solution {
  
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
    ana.keySet().stream().filter(k -> ana.get(k).size()>1).forEach(k -> ana.get(k).forEach(v -> System.out.print(v+" ")));
  }
  
  
  public static void main(String[] args) {
    
    String input = "cat dog tac sat tas god dog";
    setOfAnagrams(input);
    
    
  }
}
