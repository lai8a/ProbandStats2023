//--------------------------------------------------------------------
// Laiba Khan, CSCI3327 Probability and Applied Statistics
// Chapter 1:
// StatsLibrary: Test Cases for SetOperations 
//--------------------------------------------------------------------

import java.math.BigInteger;
import java.util.*;

public class Test extends SetOperations {
    public static void main(String[] tests){
//Chapter 1: Mean Median Mode ----------------------------------------
    //Mean tests: 
    double[] testMean1 = {8, 13, 20, 35, 9, 45, 60};
    Object answer1 = Mean(testMean1);
    System.out.println(answer1);

    double[] testMean2 = {89, 23, 90, 5, 100, 6, 1, 10, 11, 0, 12};
    Object answer2 = Mean(testMean2);
    System.out.println(answer2);

    //Median tests: 
    double[] testMedian1 = {1, 2, 3, 4, 5, 3};
    Double answer3 = Median(testMedian1);
    System.out.println("Median test 1: " + answer3);

    double[] testMedian2 = {10, 7, 5, 3, 1, 9};
    Double answer4 = Median(testMedian2);
    System.out.println(answer4);

    //Mode tests: 
    double[] testMode1 = {1, 3, 10, 5, 6, 6, 40, 5, 356, 2, 6};
    List<Double> answer5 = Mode(testMode1);
    System.out.println(answer5);

    double[] testMode2 = {2, 2, 2, 2, 2, 6, 6, 6, 6, 6};
    List<Double> answer6 = Mode(testMode2);
    System.out.println(answer6);
//Chapter 1: Standard Deviation Variance --------------------------------
    //Stand dev tests:
    double[] testSD1 = {6, 8, 42, 90, 79, 56, 500};
    Double answer7 = StandDev(testSD1);
    System.out.println("Standard deviation test 1: " + answer7);

    double[] testSD2 = {4, 5, 92, 100, 235, 3566, 123, 100, 100, 23};
    Double answer8 = StandDev(testSD2);
    System.out.println("Standard deviation test 2: " + answer8);

    //Variance tests: 
    Double answer9 = Variance(answer7);
    System.out.println("Variance test 1: " + answer9);

    Double answer10 = Variance(answer8);
    System.out.println("Variance test 2: " + answer10);

//Chapter 2: Set Theory: Union Intersection Compliment --------------------
    //Union tests:
    Integer[] list1 = {1, 2, 3, 4, 5, 6};
    Integer[] list2 = {5, 6, 7, 8, 9, 10};
    List<Integer> answer11 = Union(list1, list2);
    System.out.println("Union test 1: " + answer11);

    Integer[] list3 = {2, 3, 4, 5, 3, 7};
    Integer[] list4 = {0, 5, 7, 6, 5, 10, 9, 1, 2};
    List<Integer> answer12 = Union(list3, list4);
    System.out.println("Union test 2: " + answer12);

    //Intersection tests:
    List<Integer> answer13 = Intersect(list1, list2);
    System.out.println("Intersect test 1: " + answer13);

    List<Integer> answer14 = Intersect(list3, list4);
    System.out.println("Intersect test 2: " + answer14);

    //Compliment tests:
    List<Integer> answer15 = Compliment(list1, list2);
    System.out.println("Compliment test 1: " + answer15);

    List<Integer> answer16 = Compliment(list3, list4);
    System.out.println("Compliment test 2: " + answer16);

//Chapter 2: Factorial (Big Integer) --------------------------------------
    //Factorial tests:
    BigInteger answer17 = Factorial(5);
    System.out.println("Factorial test 1: " + answer17);

    BigInteger answer18 = Factorial(20);
    System.out.println("Factorial test 2: " + answer18);

    BigInteger answer19 = Factorial(0);
    System.out.println("Factorial test 3" + answer19);

//Chapter 2: Permutations Combinations --------------------------------------

    BigInteger answer20 = Permutations(10, 5);
    System.out.println("Permutation test 1: " + answer20);

    BigInteger answer21 = Permutations(5, 10);
    System.out.println("Permutation test 2: " + answer21);

//Chapter 2: Conditional and Bayes -----------------------------------------
    //Conditional
    Integer A[] = {11, 12, 13, 14, 15, 16};
    Integer B[] = {11, 13, 15, 21, 25};
    Integer s[] = {11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26};

    Integer A2[] = {1, 3, 4, 5, 6, 7};
    Integer B2[] = {1, 4, 5, 6, 34, 97, 90};
    Integer s2[] = {1, 2, 3, 4, 5, 6, 7, 34, 97, 49, 90};

    Double answer22 = Conditional(A, B, s);
    System.out.println("Conditional test 1: " + answer22);

    Double answer23 = Conditional(A2, B2, s2);
    System.out.println("Conditional test 1: " + answer23);

    //Bayes
    Double answer24 = Bayes(A, B, s);
    System.out.println("Bayes test 1: " + answer24);

    Double answer25 = Bayes(A2, B2, s2);
    System.out.println("Bayes test 2: " + answer25);

//Chapter 2: Independence --------------------------------------------------

    Boolean answer26 = Independence(A, B, s);
    System.out.println("Independence test 1: " + answer26);

    Boolean answer27 = Independence(A2, B2, s2);
    System.out.println("Independence test 2: " + answer27);

//Chapter 3: Binomial --------------------------------------------------

    Double answer28 = Binomial(10, 3, .3);
    System.out.println("Binomial test 1: " + answer28);

    Double answer29 = Binomial(20, 14, .6);
    System.out.println("Binomial test 2: " + answer29);

//Chapter 3: Geometric --------------------------------------------------

    Double answer30 = Geometric(3, .3);
    System.out.println("Geometric test 1: " + answer30);

    Double answer31 = Geometric(14, .6);
    System.out.println("Geometric test 2: " + answer31);

//Chapter 3: HyperGeometric --------------------------------------------------

    Double answer32 = Hypergeometric(2, 5, 20, 8);
    System.out.println("Hypergeometric test 1: " + answer32);

    Double answer33 = Hypergeometric(1, 6, 25, 10);
    System.out.println("Hypergeometric test 2: " + answer33);

//Chapter 3: Negative Binomial --------------------------------------------------

    Double answer34 = NegBinomial(7, 3, .4);
    System.out.println("NegBinomial test 1: " + answer34);

    Double answer35 = NegBinomial(9, 1, .45);
    System.out.println("NegBinomial test 2: " + answer35);

//Chapter 3: Poisson --------------------------------------------------

    Double answer36 = Poisson(4.5, 3);
    System.out.println("Poisson test 1: " + answer36);

    Double answer37 = Poisson(6, 2);
    System.out.println("Poisson test 2: " + answer37);

//Chapter 3: Chevychev --------------------------------------------------

    Double answer38 = Chevychev(2);
    System.out.println("Chevychev test 1: " + answer38);

    Double answer39 = Chevychev(6);
    System.out.println("Chevychev test 2: " + answer39);

// Thanks for testing! :)
}   
}

