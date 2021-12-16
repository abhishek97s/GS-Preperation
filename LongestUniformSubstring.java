/**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;

public class Solution {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

  static int[] longestUniformSubstring(String input){
    // your code goes here
    
            int idx = 1;    //index
            int longestLength = 0;  //set length of longest substring to 0
            int longestStart = -1;  //set starting idx of longest substring to 0
    
            while (idx < input.length())  //loop to iterate over original string
            {
                int start = idx - 1;  //start idx, initially set to 0
                int count = 1;       //counter variable, set to 1
              
                //loop to count uniform substring from idx 
                while (idx < input.length() && input.charAt(idx) == input.charAt(idx - 1))
                {
                    idx++;
                    count++;
                    //System.out.println("idx: "+idx+" count: "+count);
                }
                
                //check if last found substring is the longest one
                if (count > longestLength)
                {
                    longestStart = start;
                    longestLength = idx-1;
                }
                
                idx++; //incriment the index
            }
            System.out.println(Arrays.toString(new int[]{ longestStart, longestLength }));
            return new int[]{longestStart, longestLength};
    
  }

  public static void main(String[] args) {
    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAA", new int[]{2, 6});
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