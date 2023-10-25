//--------------------------------------------------------------------
// Laiba Khan, CSCI3327 Probability and Applied Statistics
// Chapter 1:
// StatsLibrary: Standard Deviation and Variance
//--------------------------------------------------------------------
public class StandarddeviationVariance extends MeanMedianMode{
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

    public static void main(String[] tests){
        //Standard deviation tests:
        double[] testSD1 = {6, 8, 42, 90, 79, 56, 500};
        Double answer1 = StandDev(testSD1);
        System.out.println("Standard deviation test 1: " + answer1);

        double[] testSD2 = {4, 5, 92, 100, 235, 3566, 123, 100, 100, 23};
        Double answer2 = StandDev(testSD2);
        System.out.println("Standard deviation test 2: " + answer2);

        //Variance tests: 
        Double answer3 = Variance(answer1);
        System.out.println("Variance test 1: " + answer3);

        Double answer4 = Variance(answer2);
        System.out.println("Variance test 2: " + answer4);
    }
}
