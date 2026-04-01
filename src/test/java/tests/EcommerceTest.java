package tests;
 
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
 
public class EcommerceTest extends BaseTest {
 
    @Test
    public void testEcommerceFlow() {
 
        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
 
        // Step 1: Close popup
        home.closePopup();
 
        // Step 2: Search + Enter on the prompt
        home.searchAndEnter();
 
        // Step 3: Sort by newest
        search.clickNewestFirst();
 
        // Step 4: Print top 5
        search.printTop5Mobiles();
 
        //Step 5: Validate price
        int price = search.getFirstMobilePrice();
 
        System.out.println("First Mobile Price: " + price);
 
        Assert.assertTrue(price < 30000, 
        	    "Expected price to be less than 30000, but found: " + price);
    }
}