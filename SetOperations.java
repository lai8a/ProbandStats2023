
/**
* Methods for Set Operations and formulas covered in class. 
* 
* 
* <p>
* These methods can be called within the terminal, using Method (parameters)
* 
* 
* 
* Mean Median Mode:
* @param  listofnums  an absolute URL giving the base location of the image
* @return 
* 
*/
//--------------------------------------------------------------------
// Laiba Khan, CSCI3327 Probability and Applied Statistics
//--------------------------------------------------------------------

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetOperations {

//Chapter 1: Mean Median Mode ----------------------------------------

    public static Double Mean(double[] listofnums){
        //Return a 0 if there is no numbers within the list. 
        //This way, you can avoid doing unnecessary math.
        if (listofnums.length == 0){
            return Double.NaN;
        }
        else{
            double numerator = 0.0;
            //Iterates through list and adds each value to 
            //create the numerator for the function.
            for (double value : listofnums){
                numerator += value;
            }
            //Sum of all values divided by number of terms.
            return numerator/listofnums.length;            
        }
    }
    
    public static Double Median(double[] listofnums){
        if (listofnums.length == 0){
            return Double.NaN;
        }
        //Calculates the index for value in the middle of the array.
        //If the index is even, it takes the mean of the two middle numbers.
        //If not, the value of the index is simply returned.
        int medianindex = listofnums.length/2;
        if (listofnums.length % 2 == 0){
            double median = (listofnums[medianindex] + listofnums[medianindex - 1]) / 2;
            return median;
        }
        else {
            double median = listofnums[medianindex];
            return median;
        }
    }

    public static List<Double> Mode(double[] listofnums){
        //Create a new list to track the occurences of each value.
        List<Double> Mode = new ArrayList<>();
        int maxOccurrences = 0;
        
        //Return alternate values or a string if there is 0 or 1 values in list.
        //This way, you avoid any unecessary math.
        if (listofnums.length == 0){
            Mode.add(Double.NaN);
        }
        else if (listofnums.length == 1){
            Mode.add(listofnums[0]);
        }

        else{
            for (double value : listofnums){
                int occurrences = 0;
            
                for (double num : listofnums){
                    if (value == num){
                        occurrences++;
                    }
                }

                if (occurrences > maxOccurrences){
                    maxOccurrences = occurrences;
                    Mode.clear();
                    Mode.add(value);
                }
                else if (occurrences == maxOccurrences && !Mode.contains(value)){
                    Mode.add(value);
                }
            }    
        }
    
    return Mode;  
    } 

//Chapter 1: Standard Deviation / Variance ----------------------------------------

    public static Double StandDev(double[] listofnums){
        double N, mean, SD;
        double sum = 0.0;
        //Find mean.
        mean = Mean(listofnums);
        N = listofnums.length;
        //Find sum(x - mean)^2 portion of equation.
        for (double x : listofnums){
            double distsquare = (x - mean) * (x - mean);
            sum += distsquare;
        }

        SD = Math.sqrt(sum / N);
        return SD;
    }

    //Variance is Standard Deviation to the second power. V = 
    public static Double Variance(double SD){
        //Input result from the Standard Devition method and get variance.
        double variance = SD * SD;
        return variance;
    }

//Chapter 2: Union Intersect Compliment ----------------------------------------

    //Union is the combinations of two lists.
    //Take the parameters of two lists.
    public static List<Integer> Union(Integer[] list1, Integer[] list2) {
        // Create a HashSet to store unique elements.
        HashSet<Integer> unionSet = new HashSet<>();
            
        // Add all elements from list1 to the set
        unionSet.addAll(Arrays.asList(list1));

        // Add all elements from list2 to the set
        unionSet.addAll(Arrays.asList(list2));

        // Create a new ArrayList to store the union
        List<Integer> union = new ArrayList<>(unionSet);

        return union;
    }
    
    //Intersection of two lists is the elements both lists have in common.
    //Take the parameters of two lists.
    public static List<Integer> Intersect(Integer[] list1, Integer[] list2){
        List<Integer> intersect = new ArrayList<>();
        
        //Iterate throught the values in list2 for each value in list1 to check if they equal.
        //If they are equal, add the value to a new list.
        for(int i : list1){
            for (int j : list2){
                //Check if values are equal. Add to list if true.
                if (i == j){
                    intersect.add(i);
                }
            }            
        }
        return intersect;
    }

    //The compliment of the list will be the remaining elements required to complete
    //the list. Or rather, add to the subset to turn it into the original arraylist.
    //Take the parameters of a list and its subset.
    public static List<Integer> Compliment(Integer[] list, Integer[] A){
        List<Integer> compliment = new ArrayList<>();
        for (int i : list){
            if (!Arrays.asList(A).contains(i)){
                compliment.add(i);
            }
        }
        return compliment;
    }

//Chapter 2: Factorial (Big Integer) ---------------------------------------- 

    public static BigInteger Factorial(int n){

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
    
//Chapter 2: Permutations Combinations ---------------------------------------- 

    public static BigInteger Permutations(int n, int r){
        //Solve for nPr = n!/(n-r)!.
        //n is the total number of objects.
        //r is the number of objects selected.

        //Only run if n is greater or equal to r, since it would not be possible
        //to do a permutation otherwise.
        if (n >= r){
            BigInteger numerator = Factorial(n);
            int temp = n - r;
            BigInteger denominator = Factorial(temp);
            BigInteger result = numerator.divide(denominator);
            return result;            
        }
        else {
            throw new RuntimeException("\nERROR: you selected more objects than you have");
        }
 
    }

    public static BigInteger Combinations(int n, int r){
        //Solve for nCr = n!/r!(n-r)!.
        //Just multiply Permutation equation by 1/r!.

        //Initialize value 1 and r! to variables
        BigInteger rFact = Factorial(r);
        BigInteger one = BigInteger.ONE;

        //Find 1/r!.
        BigInteger fraction = one.divide(rFact);

        //Find permutation.
        BigInteger perm = Permutations(n, r);

        //Multiply them.
        BigInteger result = fraction.multiply(perm);

        return result;

    }

    public static Double Conditional(Integer[] A, Integer[] B, Integer[] s){
        //Solve for P(A|B) = P(A ∩ B)/P(B).
        //Probability of A given B has occured.
        //'∩' is symbol for intersection.
        
        //Keep in mind P(A ⋂ B) = n(A ⋂ B)/n(S), where n(A ⋂ B) is number of elements in set A and B
        //and n(S) is number is elements in the sample space
        
        List<Integer> AinterB = Intersect(A, B);

        Integer numAinterB = AinterB.size();

        //n(S)
        Integer slength = s.length;
        //Length of A and B.
        Integer Alength = A.length;
        Integer Blength =  B.length;


        double PA = (double) Alength / slength;
        double PB = (double) Blength / slength;

        //P(A ⋂ B) = n(A ⋂ B)/n(S)
        Integer probAinterB = numAinterB / numAinterB;

        double result = probAinterB / PB;

        return result;
 
    }
}

