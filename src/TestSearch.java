import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to search ,
 * So that I can find what I need quickly.
 * 
 */

public class TestSearch {
	
	static WebDriver driver = new HtmlUnitDriver();
	  private String baseUrl;


	  @Before
	  public void setUp() throws Exception {
	    baseUrl = "https://offerupnow.com/";
	    driver.get(baseUrl);;
	  }
	  
	// Given that I am on the main page
	// When I enter "table" in the search field
	// Then I see that filter word "table" and tables in sales.
	 
	  @Test
	  public void testSearchTable() throws Exception {
	 
//	    driver.findElement(By.name("q")).clear();
		 
	    driver.findElement(By.name("q")).sendKeys("bed");
	  driver.findElement(By.id("search-submit-button")).click();
	  
	   String title=driver.getTitle();
	   System.out.println(title);
	    assertTrue(title.contains("bed"));
	
	  }


}
