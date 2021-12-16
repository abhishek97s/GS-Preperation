
// find the median of the two sorted arrays.
 // ex. {1, 3} and {2} is 2


public class Solution
{

	public static int checkIfMedian(int n, int index) {
		if(index == (n-1)/2) {
			return 1;
		}
		if(n%2 == 0 && index == n/2) {
			return 1;
		}
		return -1;
	}

  public static double logic(int[] A, int[] B) {
  	int lenA = A.length;
	int lenB = B.length;
	int n = lenA + lenB;
	int indexA = 0;
 	int indexB = 0;
	int index = 0;
	int val;
	double median = -1;
	while(indexA < lenA && indexB < lenB) {
		if(A[indexA] < B[indexB]) {
			val = A[indexA];
			index++;
			indexA++;
		}
		else {
			val = B[indexB]
			index++;
			indexB++;
		}
		int temp = checkIfMedian(n, index-1);
		if(temp != -1) {
			median = (double) val;
			if(n%2 != 0) {
				return median;
			}
		}	
	}
  //your code
  }

  public static boolean pass()
  {
  boolean result = true;
  result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
  return result;
  };

  public static void main(String[] args)
  {
  if(pass())
  {
    System.out.println("pass");
  }
  else
  {
    System.out.println("some failures");
  }
  }
}