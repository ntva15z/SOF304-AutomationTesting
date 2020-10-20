package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName){
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int getRowCount() {
        int rowcount = 0;
        try {
            rowcount = sheet.getPhysicalNumberOfRows();
//            System.out.println("no of rows: " + rowcount);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return  rowcount;
    }

    public static int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//            System.out.println("no of columns: " + colCount);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return colCount;
    }

    public static String getCellDataString(int rowNum,int colNum) {
        String cellData = null;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cellData;
    }
}