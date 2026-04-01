package pages;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
import java.util.List;
 
public class HomePage {
 
    WebDriver driver;
    WebDriverWait wait;
 
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
 
    @FindBy(xpath = "/html/body/div[5]/div/span")
    WebElement closePopup;
 
    @FindBy(name = "q")
    WebElement searchBox;
 
    public void closePopup() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closePopup)).click();
        } catch (Exception e) {
            System.out.println("No popup");
        }
    }
 
    public void searchAndEnter() {
 
        searchBox.sendKeys("mobiles under 15000");
        searchBox.sendKeys(Keys.ENTER);
        
    }
}