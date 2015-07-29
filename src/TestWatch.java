import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestWatch {

	 WebDriver driver = new FirefoxDriver();
	   String baseUrl;
	 
	  @Before
	  public void setUp() throws Exception {
		   
	    baseUrl = "https://offerupnow.com/";
	    driver.get(baseUrl);
	    
	    
        driver.findElement(By.id("login")).click();
		driver.findElement(By.id("id_login")).sendKeys(
				"zhanglan_mini@hotmail.com");
		driver.findElement(By.id("id_password")).sendKeys("Zhanglan");
		WebElement submitButton = driver.findElement(By
				.xpath("//*[@id='login-form']/div[3]/input"));
		submitButton.click();
	 
		
	  }


	  
	// Given that I am on the item page and I have logged in.
	// When I cliked watch
	// Then I add this item to watching list.
	 
	  @Test
	  public void testWatchItem() throws Exception {
		  
		  driver.get("https://offerupnow.com/item/detail/31329942/panoramic-puzzle");
		  if(!driver.findElement(By.linkText("Watch")).isDisplayed()){
			  driver.findElement(By.linkText("Watching")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  } 
		 //click watch button
		  driver.findElement(By.linkText("Watch")).click();
		  //wait for element changing
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  WebElement watching=driver.findElement(By.linkText("Watching"));
		  assertTrue(watching.isDisplayed());
		  
	  }
	  
		 
	  @Test
	  public void testUnwatchItem() throws Exception {
		  
		  driver.get("https://offerupnow.com/item/detail/31329942/panoramic-puzzle");
		  if(!driver.findElement(By.linkText("Watching")).isDisplayed()){
			  driver.findElement(By.linkText("Watch")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  }
		 //click watch button
		  driver.findElement(By.linkText("Watching")).click();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 String change= driver.findElement(By.className("add_to_watchlist_btn")).getText();
		 assertEquals(change,"Watch");
		  
	  }
	  
	  @Test
	  public void testWatchingList() throws Exception {
		  
		    driver.get(baseUrl + "/item/myoffers/");
		    driver.findElement(By.linkText("My Offers")).click();
		    driver.findElement(By.cssSelector("a[href='/item/watchingoffers/']")).click();
		    driver.findElement(By.linkText("chair")).click();
		  
	  }
		  
}
