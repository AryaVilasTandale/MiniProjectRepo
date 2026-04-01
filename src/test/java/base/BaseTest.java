package base;
 
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.DriverFactory;
 
public class BaseTest {
    //This is a BaseTest Class
    public WebDriver driver;
 
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get("https://www.flipkart.com/");
    }
 
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}