import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestSignUp {

	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("https://offerupnow.com/");
	}


	@Test
	public void FacebookAccountTest() {
		driver.findElement(By.id("login")).click();
		
		driver.findElement(By.id("email")).sendKeys("zhanglan_mini@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345678zhanglan");
		
		driver.findElement(By.id("u_0_2")).click();
		new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/a/div/div[2]"))
			);
		WebElement Username=driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/a/div/div[2]"));
	    assert
	}

}
