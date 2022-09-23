import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        Database db = null;
        DatabaseFactory dbFactory = new DatabaseFactory();


        System.out.println("Enter your message: ");
        String message = scan.nextLine();
        System.out.println("Which database would you like to save this to? (PostgresSQL, MySQL, or OracleSQL): ");
        String databaseType = scan.nextLine();


        db = dbFactory.getDbObject(databaseType);
        db.insertMessage(message);
    }
}
