package com.gs.high;

/*

** There is a staircase with 'n' number of steps. A child
** walks by and wants to climb up the stairs, starting at
** the bottom step and ascending to the top.instead
** of taking 1 step at a time, it will vary between taking
** either 1, 2 or 3 steps at a time.
** Given 'n' number of steps below method should find
** number of
** unique combinations the child could traverse.
** An example would be countSteps(3) == 4:
** 1 1 1
** 2 1
** 1 2
** 3
*/

public class StairCase
{
  public static Integer countSteps(Integer n)
  {
	  	int res[] = new int[n+1];	//Store number of combinations
		int temp = 0;
		res[0] = 1;
		int m= 1;
		
		for(int i = 1; i <= n; i++)
		{
		if (i > m)
			temp -= res[i - m - 1];
		temp += res[i-1];
		res[i] = temp;
		}

		return res[n];
  }


  public static boolean doTestsPass()
  {
    return countSteps(3) == 4
      && countSteps(4) == 7;
  }

  public static void main(String[] args)
  {
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }

    for (Integer n = 1; n <= 10; n++)
    {
      Integer numberOfCombinations = countSteps(n);
      System.out.println(n + " steps => " + numberOfCombinations);
    }
  }
}