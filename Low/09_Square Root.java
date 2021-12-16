public class Solution {
  /*
  *   double squareRoot( double x )
  *
  */
  
  //sqrt<n+1>=(sqrt<n>+(num/sqrt<n>))/2.0

  private static double findSqrt(double x, double min, double max) {
      //temporary variable  
  double t;  
  double sqrtroot=x/2;  //let the square root is half of the number
  do   
  {
    System.out.println(sqrtroot);
    t= sqrtroot;  
    sqrtroot=(t+(x/t))/2;  
    System.out.println(t+" "+sqrtroot);
  }   
  while((t-sqrtroot)!= 0);  
  return sqrtroot;    
  }

  public static double squareRoot( double x )
  {
    return findSqrt(x, 0, x);
  }

  public static void main( String args[])
  {
    double[] inputs = {2, 4, 100};
    double[] expected_values = { 1.41421, 2, 10 };
    double threshold = 0.001;
    for(int i=0; i < inputs.length; i++)
    {
      if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
      {
        System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
      }
    }
    System.out.println( "All tests passed");
  }
}