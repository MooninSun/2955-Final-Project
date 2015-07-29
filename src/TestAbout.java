import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/* As a user,
 * I would like to find some information about this website
 * So I can know my security and how the sale works.
 */

public class TestAbout {

	WebDriver driver = new FirefoxDriver();
	   String baseUrl;
	 
	  @Before
	  public void setUp() throws Exception {
		   
	    baseUrl = "https://offerupnow.com/";
	    driver.get(baseUrl);
	  }
		// Given that I am on the main page.
		// When I mouse over "About"
		// Then I see the information dropdown list
	  
	  @Test
	  public void testAboutList() throws Exception {
		  
		     Actions builder=new Actions(driver);
		    //find about
			WebElement about=driver.findElement(By.linkText("About"));
			
			//mouse over the tag
			builder.moveToElement(about).perform();
		    assertTrue(driver.findElement(By.className("dropdown-menu")).isDisplayed());
		  
	  }
	  
		// Given that I am on the main page.
		// When I click "need help?"
		// Then I see the search field and popular questions
	  
	  @Test
	  public void testAboutNeedHelp() throws Exception {
		  
		     Actions builder=new Actions(driver);
		    //find about
			WebElement about=driver.findElement(By.linkText("About"));
			builder.moveToElement(about).perform();
			
			driver.findElement(By.linkText("Need Help?")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			assertTrue(driver.getTitle().contains("Support"));
			assertTrue(driver.findElement(By.id("query")).isDisplayed());
			assertTrue(driver.findElement(By.className("promoted-articles")).isDisplayed());
		  
	  }
		// Given that I am on the main page.
		// When I click how it works
		// Then I see the introduction of how it works 
	  
	  @Test
	  public void testAboutHowItWork() throws Exception {
		  
		     Actions builder=new Actions(driver);
		    //find about
			WebElement about=driver.findElement(By.linkText("About"));
			builder.moveToElement(about).perform();
			
			driver.findElement(By.linkText("How It Works")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			assertTrue(driver.getTitle().contains("How it works"));
		  
	  }
}
