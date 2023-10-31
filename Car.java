/**--------------------------------------------------------------------
 * @author Laiba Khan, CSCI3327 Probability and Applied Statistics
 * 10/30/2023
 * Mini Programming Project
 * StatsLibrary: Car and Car Factory
 --------------------------------------------------------------------
 */
class Car
{
   String CarType;
   int Year;
   String Color;
   int Miles;


    public Car(String carType, int year, String color, int miles) {
        String CarType = carType;
        int Year = year;
        String Color = color;
        int Miles = miles;
    }

    @Override
    public String toString() {
        return CarType + ", " + Year + ", " + Color + ", " + Miles;
    }
}
