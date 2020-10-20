package TestSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;

public class TestLogin {

    WebDriver webDriver;

    @BeforeTest
    public void InitTest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:3000/login");
    }

    @BeforeMethod
    public void BeforMethod() {
        // reset web sau moi lan chay
        webDriver.navigate().to("http://localhost:3000/login");
    }

    @AfterTest
    public void CloseTest() {
        webDriver.close();
    }


    @Test(dataProvider = "data-source")
    public void testUsername(String username, String password) throws Exception {

            webDriver.findElement(By.name("email")).sendKeys(username);
            webDriver.findElement(By.name("password")).sendKeys(password);
//        WebElement btnLogin = webDriver.findElement(By.xpath("input[@type='submit']"));
            WebElement btnLogin = webDriver.findElement(By.name("btnLogin"));
            btnLogin.click();
            Thread.sleep(2000);
            WebElement alert = webDriver.findElement(By.id("swal2-content"));

            Assert.assertEquals("Login Success!",alert.getText());
    }


    @DataProvider(name = "data-source")
    public static Object[][] getData() {
        String projectpath = System.getProperty("user.dir");
        String excelPath = projectpath + "/excel/testLogin.xlsx";
        Object data[][] = testData(excelPath, "login");
        return data;
    }

    public static Object[][] testData(String excelPath, String sheetName) {
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
//                System.out.println(cellData + " | ");
                data[i - 1][j] = cellData;
//                System.out.println(data[i-1][j]);
            }
//            System.out.println();
        }
        return data;
    }



//    public static Object[][] combine(Object[][] a1, Object[][] a2){
//        List<Object[]> objectCodesList = new LinkedList<>();
//        for(Object[] o : a1){
//            for(Object[] o2 : a2){
//                objectCodesList.add(concatAll(o, o2));
//            }
//        }
//        return objectCodesList.toArray(new Object[0][0]);
//    }
//
//
//    @SafeVarargs
//    public static <T> T[] concatAll(T[] first, T[]... rest) {
//        //calculate the total length of the final object array after the concat
//        int totalLength = first.length;
//        for (T[] array : rest) {
//            totalLength += array.length;
//        }
//        //copy the first array to result array and then copy each array completely to result
//        T[] result = Arrays.copyOf(first, totalLength);
//        int offset = first.length;
//        for (T[] array : rest) {
//            System.arraycopy(array, 0, result, offset, array.length);
//            offset += array.length;
//        }
//
//        return result;
//    }
}
