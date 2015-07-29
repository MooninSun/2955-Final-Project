import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCategory {

	static WebDriver driver = new FirefoxDriver();
	  private String baseUrl;


	  @Before
	  public void setUp() throws Exception {
	    
	    baseUrl = "https://offerupnow.com/";
	    driver.get(baseUrl);
	   
	  }

	  @Test
	  public void testBaby() throws Exception {
	    
	    driver.findElement(By.linkText("Baby & Kids")).click();
	    //jump to new a page
	    assertTrue(driver.getTitle().contains("Baby & Kids"));
	    
	    //test filter word in the new page
	    WebElement filter=driver.findElement(By.xpath("//span[@class='round nowrap color-branch']"));
	    assertEquals(filter.getText(),"Baby & Kids");
	  }

}
