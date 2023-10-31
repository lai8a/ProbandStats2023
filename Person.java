
/**--------------------------------------------------------------------
 * @author Laiba Khan, CSCI3327 Probability and Applied Statistics
 * 10/30/2023
 * Mini Programming Project
 * StatsLibrary: Birthday Checker
 --------------------------------------------------------------------
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Researched LocalDate & MonthDay import.
//Utilized : https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
import java.time.MonthDay;

//Determine the probability of any two people sharing a birthday
//in the class.
public class Person extends SetOperations{
    //Is made flexible: user will input the # of randomly generated people
    public int day;
    public int month;

    private static List<MonthDay> allBirthdays = new ArrayList<>();

    public Person(String bday) {
        //Split the input into month and day when faced with '/' character.
        String[] date = bday.split("/");
        //Only parse when length iff both day and month are in date.
        if (date.length == 2){
            try{
                this.month = Integer.parseInt(date[0]);
                this.month = Integer.parseInt(date[1]);   
               
                //Throw exception if input not following the bounds.
                if (this.month < 1 || this.month > 12 || this.day < 1 || this.day > 31) {
                    throw new IllegalArgumentException("Invalid month or day");
                }
                
                //Add birthday to static list.
                allBirthdays.add(MonthDay.of(this.month, this.day));
            }

            catch(NumberFormatException e){
                throw new IllegalArgumentException("Invalid format");
            }

        }
        //Throw exception if not 2 elements.
        else {
            throw new IllegalArgumentException("Invalid format");
        } 
    }

    public static List<MonthDay> RandomBirthdays(int numofpeople){
        List<MonthDay> bdaylist = new ArrayList<>();
        Random random = new Random();

        //Generates random variable for month and day with accurate bounds.
        //Does not take into account leap years.
        for (int i = 0; i < numofpeople; i++){
            //Randomly generate a person/birthday.
            int randmonth = random.nextInt(12) + 1;
            int randday = random.nextInt(31) + 1;

            //Add these together into the list 'bdaylist'.
            MonthDay randBirthday = MonthDay.of(randmonth, randday);
            bdaylist.add(randBirthday);

            // Add the random birthday to the list
            allBirthdays.add(randBirthday);
        }

        return bdaylist;
    }
    //Helper function to help convert List<MonthDay> to MonthDay[], making it compatable for 
    //Intersection method.

    private static MonthDay[] toMonthDayArray(List<MonthDay> list) {
        MonthDay[] array = new MonthDay[list.size()];
        return list.toArray(array);
    }
    
    public static double calculateSharedBirthdayProbability(int numRuns) {
        int sharedCount = 0;

        for (int i = 0; i < numRuns; i++) {
            List<MonthDay> randomBirthdays = RandomBirthdays(allBirthdays.size());
            MonthDay[] BirthdaysArray = toMonthDayArray(allBirthdays);
            MonthDay[] randomBirthdaysArray = toMonthDayArray(randomBirthdays);

            int SAMEbdays = Intersect(BirthdaysArray, randomBirthdaysArray).size();

            if (SAMEbdays >= 2) {
                sharedCount++;
            }
        }

        return (double) sharedCount / numRuns;
    
    }

}
