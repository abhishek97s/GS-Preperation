import java.util.*;

public class Solution
{
	/**
	   * Return an array containing prime numbers whose product is x
	   * Examples:
	   * primeFactorization( 6 ) == [2,3]
	   * primeFactorization( 5 ) == [5]
	   */
  public static ArrayList<Integer> primeFactorization(int x)
  {
  	ArrayList<Integer> primeFac = new ArrayList<Integer>();
	if(x < 2) {return primeFac;}
	if(x == 2) {
		primeFac.add(2);
		return primeFac;
	}
	int temp = x;
	for(int i = 2; i <= Math.sqrt(temp); i++) {
		if(x%i == 0) {
			primeFac.add(i);
			while(x % i == 0 && x > 1) {
				x = x/i;
			}	
		}	
	}
	if(x > 2) {
		primeFac.add(x);
	}
	return primeFac;
  }

  public static void main(String args[])
  {
	
	System.out.println(primeFactorization(315) + " " + primeFactorization(5)); 
	if(primeFactorization(42).equals(Arrays.asList(2,3,7)) 
			&& 
			primeFactorization(5).equals(Arrays.asList(5))
			) {
		System.out.println("All passed");
	}else {
		System.out.println("Failed");
	}
  
  }
}