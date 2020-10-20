package TestSelenium;

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

import java.util.concurrent.TimeUnit;

public class TestDataRegister {
    WebDriver webDriver;

    @BeforeTest
    public void InitTest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/shoptuti/dang-ki?action=register");
    }

//    @BeforeMethod
//    public void BeforMethod() {
//        // reset web sau moi lan chay
//        webDriver.navigate().refresh();
//    }

    @AfterTest
    public void CloseTest() {
        webDriver.close();
    }

    @Test
    public void Test1UsernameInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        for (int i = 1; i <= rowCount - 15; i++) {
            String username = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);
            webDriver.findElement(By.name("username")).sendKeys(username);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void Test2FullnameInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        webDriver.findElement(By.name("username")).sendKeys("anhyeuem");

        for (int i = 4; i <= rowCount - 14; i++) {
            String fullname = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);
            webDriver.findElement(By.name("fullname")).sendKeys(fullname);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void Test3BirhDayInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        webDriver.findElement(By.name("fullname")).sendKeys("Nguyen Huy Hoang");
        for (int i = 5; i <= rowCount - 10; i++) {
            String birthday = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);

            webDriver.findElement(By.name("birthday")).sendKeys(birthday);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void Test4EmailInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        webDriver.findElement(By.name("birthday")).sendKeys("1990-06-05");
        for (int i = 8; i <= rowCount - 8; i++) {
            String email = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);

            webDriver.findElement(By.name("email")).sendKeys(email);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void Test5PhoneNumberInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        webDriver.findElement(By.name("email")).sendKeys("admin@gmail.com");
        for (int i = 10; i <= rowCount - 5; i++) {
            String phone = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);

            webDriver.findElement(By.name("phone")).sendKeys(phone);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void Test6PasswordInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        webDriver.findElement(By.name("phone")).sendKeys("0985224906");
        for (int i = 14; i <= rowCount - 3; i++) {
            String password = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);

            webDriver.findElement(By.name("password")).sendKeys(password);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    @Test
    public void Test7ConfirmPasswordInvalid() throws Exception {
        String projectpath = System.getProperty("user.dir");
        String xl = projectpath + "/excel/testCaseLogin.xlsx";

        String sheet = "Register";
        int rowCount = Excel.getRowCount(xl, sheet);
        System.out.println(rowCount);
        webDriver.findElement(By.name("password")).sendKeys("anh123");
        for (int i = 12; i <= rowCount; i++) {
            String confirm = Excel.getCellValue(xl, sheet, i, 3);
            String expected = Excel.getCellValue(xl, sheet, i, 4);

            webDriver.findElement(By.name("confirm")).sendKeys(confirm);
            webDriver.findElement(By.name("btnRegister")).click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.name("msg"));
            Assert.assertEquals(expected, alert.getText());
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
    }

    
}
