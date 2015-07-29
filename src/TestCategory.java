import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user,
 * I would like to go through time by category and search item based on category ,
 * So that I can find narrow what I go through.
 *  
 */


public class TestCategory {

	static WebDriver driver = new FirefoxDriver();
	  private String baseUrl;


	  @Before
	  public void setUp() throws Exception {
	    
	    baseUrl = "https://offerupnow.com/";
	    driver.get(baseUrl);
	   
	  }
	  
		// Given that I am on the main page
		// When I click Baby & Kids
		// Then I see that filter word "Baby & Kids" and items related to "Baby & Kids".

	  @Test
	  public void testBaby() throws Exception {
	    
	    driver.findElement(By.linkText("Baby & Kids")).click();
	    //jump to new a page
	    assertTrue(driver.getTitle().contains("Baby & Kids"));
	    
	    //test filter word in the new page
	    WebElement filter=driver.findElement(By.xpath("//span[@class='round nowrap color-branch']"));
	    assertEquals(filter.getText(),"Baby & Kids");
	  }
	  
	  
		// Given that I am on the "Baby & Kids" page
		// When I click Baby & Kids
		// Then I see that filter word "Baby & Kids" and "bed"  and items related to bed of Baby & Kids.
	  
	  @Test
	  public void testNarrowBaby() throws Exception {
	    
	    driver.findElement(By.linkText("Baby & Kids")).click();
	    
	    //search
		  driver.findElement(By.name("q")).sendKeys("bed");
		  driver.findElement(By.id("search-submit-button")).click();
		  
		  //two filter word in the new page
		  WebElement filter=driver.findElement(By.xpath("//span[@class='round nowrap color-branch'][1]"));
		  assertEquals(filter.getText(),"bed");
		  WebElement filter1=driver.findElement(By.xpath("//span[@class='round nowrap color-branch'][2]"));
		  assertEquals(filter1.getText(),"Baby & Kids");
	  }

}
