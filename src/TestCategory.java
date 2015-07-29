import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class TestCategory {

	static WebDriver driver = new HtmlUnitDriver();
	  private String baseUrl;


	  @Before
	  public void setUp() throws Exception {
	    
	    baseUrl = "https://offerupnow.com/";
	    driver.get(baseUrl);
	   
	  }

	  @Test
	  public void testBaby() throws Exception {
	    
	    driver.findElement(By.linkText("Baby & Kids")).click();
	    System.out.println(driver.getTitle());
	    assertTrue(driver.getTitle().contains("Baby & Kids"));
	  }

}
