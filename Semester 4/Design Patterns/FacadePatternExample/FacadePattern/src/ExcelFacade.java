import java.io.IOException;

public class ExcelFacade
{
    public void generateExcelReport() throws IOException
    {
        //Gather input
        ScannerInput scan = new ScannerInput();
        double[] inputs = scan.gatherInputArray();

        //Generate Excel file with input
        GenerateExcelFile foo = new GenerateExcelFile(inputs[0], inputs[1], inputs[2]);
        foo.generateExcel();
    }
}
