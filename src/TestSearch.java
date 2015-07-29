import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user, I would like to search the bed I need, So that I can find what I
 * need quickly.
 * 
 */

public class TestSearch {

	static WebDriver driver = new FirefoxDriver();
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "https://offerupnow.com/";
		driver.get(baseUrl);
		;
	}

	// Given that I am on the main page
	// When I enter "table" in the search field
	// Then I see that filter word "table" and tables in sales.

	 
	  @Test
	  public void testSearchBed() throws Exception {
	 
		 //search bed 
		  driver.findElement(By.name("q")).sendKeys("bed");
		  driver.findElement(By.id("search-submit-button")).click();
	  
	   	 // jump to a new page
		  String title=driver.getTitle();
		  assertTrue(title.contains("bed"));
	    
		  //test filter word in the new page
		  WebElement filter=driver.findElement(By.xpath("//span[@class='round nowrap color-branch']"));
		  assertEquals(filter.getText(),"bed");
	  }
		  
	  
	//Given that I am on the main page
	//when I enter some meaningless word in the search field
	//Then I see "no offer found" message.
		  
		 @Test
		 public void testSearchAaaa() throws Exception{
			  //search "aaaa"
			 driver.findElement(By.name("q")).sendKeys("aaaa");
			 driver.findElement(By.id("search-submit-button")).click();
			 
		   	 // jump to a new page
			  String title=driver.getTitle();
			  assertTrue(title.contains("aaaa"));
		    
			  //test filter word in the new page
			  WebElement message=driver.findElement(By.className("title"));
			  assertEquals(message.getText(),"No offers found.");
			 
			 
		  }
		 
		 
	//Given that I am on the page which is the result of bed search
	//when I click "sort:closest"
	//Then I see sort selection
		  
		 @Test
		 public void testSort() throws Exception{
			  // bed search page
			 driver.get("https://offerupnow.com/search/?q=bed");
			 
			 // drop down hide
			 String oldStyle=driver.findElement(By.xpath("//div[@class='list-header-title']/ul/li[2]/ul/li/a")).getAttribute("class");
			 assertEquals(oldStyle,"");
			 
		   	 // click sort selection
			 driver.findElement(By.xpath("//div[@class='list-header-title']/ul/li[2]/ul/li/a[@href='javascript:void(0)']")).click();		    
			
			 //show the dropdown
			 String newStyle=driver.findElement(By.xpath("//div[@class='list-header-title']/ul/li[2]/ul/li/a")).getAttribute("class");
			 assertEquals(newStyle,"active");
			 String show=driver.findElement(By.xpath("//div[@class='list-header-title']/ul/li[2]/ul/li/div")).getAttribute("style");
			 assertTrue(show.contains("display: block"));
			 
		  }
		  
	
	

	@Test
	public void testSearchTable() throws Exception {

		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("bed");
		driver.findElement(By.id("search-submit-button")).click();

		String title = driver.getTitle();
		System.out.println(title);
		assertTrue(title.contains("bed"));

	}

}
