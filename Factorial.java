//--------------------------------------------------------------------
// Laiba Khan, CSCI3327 Probability and Applied Statistics
// Chapter 2:
// StatsLibrary: Factorial (Big Integer)
//--------------------------------------------------------------------
import java.math.BigInteger;

public class Factorial {
    public static BigInteger Calculate(int n){

        //If input is 0, then just return 0.
        if (n == 0){
            //Researched this on https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html.
            //BigInteger.ONE is the BigInteger 1 constant.
            //Output a 1 because 0! = 1.
            return BigInteger.ONE;
        }

        //Initialize result as 1. You also want to start loop index at 0 
        //because of this.
        BigInteger result = BigInteger.ONE;

        //Then loop from 1 to n, and multiply each value by the result.
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    public static void main(String[] args){
        //Test 1:
        BigInteger result1 = Calculate(16);
        System.out.println("Factorial is: " + result1);

        //Test 2: 
        BigInteger result2 = Calculate(20);
        System.out.println("Factorial is: " + result2);

        //Test 3:
        BigInteger result3 = Calculate(0);
        System.out.println("Factorial is: " + result3);
    }
}
