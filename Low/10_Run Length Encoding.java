import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 */
public class Solution {

  public static String rle(String input) {
    // Your code goes here
	if(input.length() == 0) {return "";}
	StringBuilder sb = new StringBuilder();
	char pre = input.charAt(0);
	int count = 0;
	for(char c : input.toCharArray()) {
		if(pre == c) {
			count++;
		}
		else {
			sb.append(c);
			sb.append(count);
			pre = c;
			count = 1;
		}	
	}
	sb.append(pre);
	sb.append(count);
    return sb.toString();
  }


 public static void main(String[] args)  {
    
	  if("".equals(rle("")) && 
			  "a1".equals(rle("a")) && 
			  "a3".equals(rle("aaa"))){
		  System.out.println("Passed");
	  }else {
		  System.out.println("Failed");
	  }
  }
}