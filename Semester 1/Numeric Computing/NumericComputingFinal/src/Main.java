import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //Step 1: Getting user's input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--SIMPLE INTEREST REPORT GENERATOR--\n");

        System.out.println("Enter your principal amount: ");
        double principal = Double.parseDouble(scanner.next());

        System.out.println("Enter your interest rate percentage: ");
        double interestRate = Double.parseDouble(scanner.next())/100;

        System.out.println("Enter how many years the interest will grow: ");
        double time = Double.parseDouble(scanner.next());



        //Step 2: Create a workbook with the simple interest calculations
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        //Creating the heading
        XSSFRow headingRow = sheet.createRow(0);
        XSSFCell timeHeadingCell = headingRow.createCell(0);
        timeHeadingCell.setCellValue("Year");
        XSSFCell amountHeadingCell = headingRow.createCell(1);
        amountHeadingCell.setCellValue("Amount");

        //Create a row, add two cells to the row that displays the year and calculated amount
        for(int i=1; i<=time; i++)
        {
            XSSFRow row = sheet.createRow(i);

            XSSFCell yearCellData = row.createCell(0);
            yearCellData.setCellValue(i);

            XSSFCell amountCellData = row.createCell(1);
            amountCellData.setCellValue((principal*(1+interestRate * (double) i)));
        }



        //Step 3: Create the Excel file and writing to it with the generated information above
        String filePath = ".\\report\\simple interest report.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
    }
}