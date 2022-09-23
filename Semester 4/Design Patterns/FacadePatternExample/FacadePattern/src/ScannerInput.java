import java.util.Scanner;

public class ScannerInput
{
    public double[] gatherInputArray()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--SIMPLE INTEREST REPORT GENERATOR--\n");

        System.out.println("Enter your principal amount: ");
        double principal = Double.parseDouble(scanner.next());

        System.out.println("Enter your interest rate percentage: ");
        double interestRate = Double.parseDouble(scanner.next())/100;

        System.out.println("Enter how many years the interest will grow: ");
        double time = Double.parseDouble(scanner.next());


        return new double[]{time, principal, interestRate};
    }
}
