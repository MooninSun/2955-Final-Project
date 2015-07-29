import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestSignUp {

	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("https://offerupnow.com/");
	}


	@Test
	public void NewuserSignupTest() {
		driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[3]/a")).click();
	
		driver.findElement(By.id("id_name")).sendKeys("testone");
		driver.findElement(By.id("id_email")).sendKeys("changliu9999@gmail.com");
		driver.findElement(By.id("id_password1")).sendKeys("11111111");
		driver.findElement(By.xpath("//*[@id='easyreg']/div[4]/input")).click();
		WebElement sign = driver.findElement(By.xpath("//*[@id='fancybox-content]/div/div/h1"));
		assertTrue(sign.getText().contains("Registering"));
		
		driver.findElement(By.className("button center")).click();;
		Actions builder=new Actions(driver);
		WebElement nametag=driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/a"));
		builder.moveToElement(nametag).perform();
		if(driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/div/ul/li[5]/a")).isDisplayed()){ 
		    System.out.println("Logout button is coming"); 
		    driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/div/ul/li[5]/a")).click();
		   }else{
			   System.out.println("No Logout button present");
		   }
	}
	
	@Test
	public void UsedEmailSignupTest() {
		driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[3]/a")).click();
	
		driver.findElement(By.id("id_name")).sendKeys("testone");
		driver.findElement(By.id("id_email")).sendKeys("laz31@pitt.edu");
		driver.findElement(By.id("id_password1")).sendKeys("11111111");
		driver.findElement(By.xpath("//*[@id='easyreg']/div[4]/input")).click();
		WebElement sign = driver.findElement(By.xpath("//*[@id='easyreg']/div[2]/div/span/ul/li"));
		assertTrue(sign.getText().contains("A user is already registered with this e-mail address."));
	}

}
