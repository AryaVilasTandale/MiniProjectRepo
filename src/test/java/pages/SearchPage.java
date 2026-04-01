package pages;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
import java.util.List;
 
public class SearchPage {
 
    WebDriver driver;
    WebDriverWait wait;
 
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
 
    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[5]")
    WebElement newestFirst;
 
    
    public void clickNewestFirst() {
        wait.until(ExpectedConditions.elementToBeClickable(newestFirst)).click();
        // Wait for the 'Newest' sort to actually process 
        // (Checking if the first element becomes 'stale' or just a hard pause for AJAX)
        try { 
        	Thread.sleep(2000); 
        	} 
        catch (InterruptedException e) { }
    }

    public void printTop5Mobiles() {
        
        List<WebElement> names = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("RG5Slk"))
        );

        List<WebElement> prices = driver.findElements(By.className("hZ3P6w"));

        System.out.println("--- Top 5 Newest Mobiles ---");
        for (int i = 0; i < 5; i++) {
          
            if (i < names.size() && i < prices.size()) {
                System.out.println((i + 1) + ". " + names.get(i).getText() + " | Price: " + prices.get(i).getText());
            }
        }
    }

    public int getFirstMobilePrice() {
        
        WebElement priceElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("hZ3P6w"))
        );

       
        String priceText = priceElement.getText().replaceAll("[^0-9]", "");
        
        return Integer.parseInt(priceText);
    }
}