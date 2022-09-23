import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Creating a scanner object
        Scanner scanner = new Scanner(System.in);


        //Gathering user information
        System.out.println("What is your weight in kg?");
        String kilograms = scanner.next();

        System.out.println("What is your height in cm?");
        String centimeters = scanner.next();

        System.out.println("What's your gender?");
        String gender = scanner.next();

        System.out.println("What's your age?");
        String age = scanner.next();

        System.out.println("What's your bodyfat percentage?");
        String bodyfatPercentage = scanner.next();

        System.out.println("What's your level of exercise on a scale of 1-5?");
        String exerciseLevel = scanner.next();


        //Get objects of each formula
        KatchMcArdle katchMcArdle = new
                KatchMcArdle(Double.parseDouble(kilograms),
                Integer.parseInt(bodyfatPercentage),
                Double.parseDouble(exerciseLevel));

        HarrisBenedictRevised harrisBenedictRevised = new
                HarrisBenedictRevised(Double.parseDouble(kilograms),
                Double.parseDouble(centimeters),
                Integer.parseInt(age),
                gender,
                Double.parseDouble(exerciseLevel));

        Cunningham cunningham = new
                Cunningham(Double.parseDouble(kilograms),
                Integer.parseInt(bodyfatPercentage),
                Double.parseDouble(exerciseLevel));

        MiffinStJeor miffinStJeor = new
                MiffinStJeor(gender,
                Double.parseDouble(kilograms),
                Double.parseDouble(centimeters),
                Integer.parseInt(age),
                Double.parseDouble(exerciseLevel));


        //Display each formula
        System.out.println("\n--TDEE Results--\n");
        System.out.println("Katch McArdle Formula: " + katchMcArdle.calculate());
        System.out.println("Harris Benedict Formula: " + harrisBenedictRevised.calculate());
        System.out.println("Cunningham Formula: " + cunningham.calculate());
        System.out.println("Miffin StJeor Formula: " + miffinStJeor.calculate());
    }
}
