/**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;

public class Solution {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

  static int[] longestUniformSubstring(String input){
    int longestStart = -1;
    int longestLength = 0;
    int count = 0;
    int start = 0;
    int idx=1;
    // your code goes here
  while(idx < input.length()) {
    if(input.charAt(idx) == input.charAt(idx-1))  count++;
    
    else {
      if(count > longestLength) {
        longestLength = count;
        longestStart = start;
          
      }  
      start = idx;
      count = 1; 
    }
    idx++;
  }
  System.out.println(count);
  if(count > longestLength) {
    longestLength = idx-1;
    longestStart = start;
        
  }
    System.out.println(Arrays.toString(new int[]{ longestStart, longestLength }));
    return new int[]{ longestStart, longestLength };
  }

  public static void main(String[] args) {
    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAA", new int[]{2, 5});
    testCases.put("abbcccdddddd", new int[]{6, 11});
    testCases.put("aa", new int[]{0, 1});

    boolean pass = true;
    for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
      int[] result = longestUniformSubstring(testCase.getKey());
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if(pass){
      System.out.println("Pass!");
    } else {
      System.out.println("Failed! ");
    }
  }
}
