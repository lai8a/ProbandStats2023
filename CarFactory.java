/**--------------------------------------------------------------------
 * @author Laiba Khan, CSCI3327 Probability and Applied Statistics
 * 10/30/2023
 * Mini Programming Project
 * StatsLibrary: Car and Car Factory
 --------------------------------------------------------------------
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CarFactory {
    //Define filename for the car data CSV file.
    private static final String Filename = "RandomCSV.csv";

    private static final String[] Types = {"Sedan", "SUV", "Truck", "Convertible"};
    private static final int CurrYear = 2023;
    private static final int MaxYearsOld = 50;
    private static final String[] Colors = {"Red", "Blue", "Black", "White", "Silver", "Yellow"};

    public static Car createRandomCar() {
        Random random = new Random();
        String carType = Types[random.nextInt(Types.length)];
        int year = CurrYear - random.nextInt(MaxYearsOld);
        String color = Colors[random.nextInt(Colors.length)];
        int miles = random.nextInt(250001);
        return new Car(carType, year, color, miles);
    }
    

    private static void generateAndExportCarData(int numCars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Filename))) {
            //Write header.
            writer.write("CarType,Year,Color,Miles\n"); 

            //Write the header to the CSV file.
            for (int i = 0; i < numCars; i++) {
                //Generate random car.
                Car car = CarFactory.createRandomCar();
                writer.write(car.toString() + "\n");
            }
        } 
        //Throw exception, print it to console if it does not write onto the file.
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Car> loadCarData(String filename) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    //Skip the header line.
                    firstLine = false; 
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    //Parse car data from the CSV line and create a Car object.
                    String carType = parts[0].trim();
                    int year = Integer.parseInt(parts[1].trim());
                    String color = parts[2].trim();
                    int miles = Integer.parseInt(parts[3].trim());
                    cars.add(new Car(carType, year, color, miles));
                }
            }
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public static void main(String[] args) {
        //Generate and export car data with 1000 cars.
        generateAndExportCarData(1000);
        List<Car> loadedCars = loadCarData(Filename);

        //Display the loaded car data.
        for (Car car : loadedCars) {
            System.out.println(car);
        }
    }    
}
