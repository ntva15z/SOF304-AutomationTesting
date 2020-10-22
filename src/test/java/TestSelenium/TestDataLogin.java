package TestSelenium;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Excel;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TestDataLogin {
    WebDriver webDriver;
//    FileInputStream fileInputStream = new FileInputStream(new File("D:\\SOF304\\Ass2-SOF304\\excel/testCaseLogin.xlsx"));
//    XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
//    XSSFSheet ass = wb.getSheet("Login");
//    public TestDataLogin() throws IOException {
//    }

    @BeforeTest
    public void InitTest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/shoptuti/dang-nhap?action=login");
    }

    @BeforeMethod
    public void BeforMethod() {
        // reset web sau moi lan chay
        webDriver.navigate().refresh();
    }

    @AfterTest
    public void CloseTest() {
        webDriver.close();
    }

    @Test
    public void TestLoginWithInvalidData() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Login";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        for (int i = 1; i <= rowCount - 1; i++) {
            String username = Excel.getCellValue(xl, sheet, i, 3);
            String password = Excel.getCellValue(xl, sheet, i, 4);
            String expected = Excel.getCellValue(xl, sheet, i, 5);
            webDriver.findElement(By.name("username")).sendKeys(username);
            webDriver.findElement(By.name("pass")).sendKeys(password);

            webDriver.findElement(By.name("btnLogin")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
//            if(expected.equals(alert.getText())){
//                Row row = ass.getRow(i);
//                Cell cell = row.createCell(7);
//                cell.setCellValue("Pass");
//                FileOutputStream file = new FileOutputStream("D:\\SOF304\\Ass2-SOF304\\excel/testCaseLogin.xlsx");
//                wb.write(file);
//            }
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void TestLoginWithValidData() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Login";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        for (int i = 5; i <= rowCount; i++) {
            String username = Excel.getCellValue(xl, sheet, i, 3);
            String password = Excel.getCellValue(xl, sheet, i, 4);
            webDriver.findElement(By.name("username")).sendKeys(username);
            webDriver.findElement(By.name("pass")).sendKeys(password);

            webDriver.findElement(By.name("btnLogin")).click();
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }
}
