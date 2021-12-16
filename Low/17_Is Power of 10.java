public class Solution
{
  /**
   * Returns true if x is a power-of-10. 
   */
  public static boolean isPowerOf10(int x)
  {
	while(x > 1) {
		if(x%10 != 0) {
			return false;
		}
		x = x/10;
	}

  return true;
  }

  public static boolean doTestsPass()
  {
  int[] isPowerList = {10};
  int[] isNotPowerList = {3};

  for(int i : isPowerList)
  {
    if(!isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  for(int i : isNotPowerList)
  {
    if(isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  System.out.println("All tested passed");
  return true;
  };


  public static void main(String args[])
  {
  doTestsPass();
  }
}