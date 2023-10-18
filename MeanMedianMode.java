//--------------------------------------------------------------------
// Laiba Khan, CSCI3327 Probability and Applied Statistics
// Chapter 1:
// StatsLibrary: Mean Median Mode and Standard Deviation Functions
//--------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class MeanMedianMode{
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

    public static void main(String[] tests){
        double[] testMean1 = {8, 13, 20, 35, 9, 45, 60};
        Object answer1 = Mean(testMean1);
        System.out.println(answer1);

        double[] testMedian1 = {1, 2, 3, 4, 5, 3};
        Double answer2 = Median(testMedian1);
        System.out.println(answer2);

        double[] testMode1 = {2, 3, 4, 5, 6, 5, 5, 7, 6, 6};
        List<Double> answer3 = Mode(testMode1);
        System.out.println(answer3);

        double[] testSD1 = {6, 8, 42, 90, 79, 56, 500};
        Double answer4 = StandDev(testSD1);
        System.out.println(answer4);
    }
}