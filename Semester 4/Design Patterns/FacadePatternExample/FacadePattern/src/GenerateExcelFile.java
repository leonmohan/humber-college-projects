import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateExcelFile
{
    private double time;
    private double principal;
    private double interestRate;

    public GenerateExcelFile(double time, double principal, double interestRate)
    {
        this.time = time;
        this.principal = principal;
        this.interestRate = interestRate;
    }

    public void generateExcel() throws IOException
    {
        //Create a workbook with the simple interest calculations
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

        //Create the Excel file and writing to it with the generated information above
        try
        {
            String filePath = ".\\report\\simple interest report.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("File generated to: " + filePath);
        }
        catch (IOException io)
        {
            System.out.println("Error: " + io);
        }
    }
}
