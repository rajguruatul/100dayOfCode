package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook1;
    static XSSFSheet xssfsheet1;

    public ExcelUtils() throws IOException {
        workbook1 = new XSSFWorkbook("C:/Users/USER/Desktop/100days/day2/ExcelDemo.xlsx");
        xssfsheet1 = workbook1.getSheet("Sheet1");
    }

    public static void main(String args[]) {
        //  getRowCount();
        getExcelData();
    }
    public static void getRowCount() {
        int rowsCount = xssfsheet1.getPhysicalNumberOfRows();
        System.out.println("rowCount is " + rowsCount);
    }

    public static void getExcelData() {
        int rowsCount = xssfsheet1.getPhysicalNumberOfRows();
        int colCount;
        String celldata;

        System.out.println("rowCount is " + rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            colCount = xssfsheet1.getRow(i).getPhysicalNumberOfCells();
            System.out.println("colCount is " + colCount);
            for (int j = 0; j < colCount; j++) {
                celldata = xssfsheet1.getRow(i).getCell(j).getStringCellValue();
                System.out.println("cell data @ row " + i + " and column " + j + " is: " + celldata);
            }
        }


    }


}
