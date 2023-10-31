/**--------------------------------------------------------------------
 * @author Laiba Khan, CSCI3327 Probability and Applied Statistics
 * 10/30/2023
 * Mini Programming Project
 * StatsLibrary: Monty Hall Problem
 --------------------------------------------------------------------
 */
 import java.util.Random;

public class MontyHall {

    //Here is a method for the door:
    public static Double Door(Boolean changeornot, int numSimulations){

        //Declare variable winCount to count how many wins.
        int winCount = 0;
        //Declare random. Also declare random door choice.
        Random random = new Random();
        int doorchosen = random.nextInt(3) + 1;

        //Iterate through for loop for each simulation until you reach desired amount of times ran.
        for (int i = 0; i < numSimulations; i++) {
            //Set car to be behind a random door 1-3.
            int car = random.nextInt(3) + 1;

            //Examine the other doors, besides what was chosen. 
            //Generate which door (with goat) to reveal.
            int hostReveals;
            do {
                hostReveals = random.nextInt(3) + 1;
            } while (hostReveals == doorchosen || hostReveals == car);
    
            int finalChoice = doorchosen;
            //Change doors if requested.
            //This switches the value of doorchosen to the other door if a change is wanted.
            if (changeornot == true) {
                do {
                    finalChoice = random.nextInt(3) + 1;
                } while (finalChoice == doorchosen || finalChoice == hostReveals);
            }

            //Counts whether or not you are a winner:
            if (finalChoice == car) {
                winCount++;
            }
        }

        //Calculate percentage of wins out of total runs x.
        //Take the average by dividing by x.
        double average = ((double) winCount / numSimulations) * 100;
        return average;
    }

    public static void main(String[] args){
        //Change the door 10,000 times.
        double result1 = Door(true, 10000);
        System.out.println("Winning percentage for changing the door 10,000 times is: " + result1 + "%");
        //Dont change the door 10,000 times.
        double result2 = Door(false, 10000);
        System.out.println("Winning percentage for NOT changing the door 10,000 times is: " + result2 + "%");
    }
}
