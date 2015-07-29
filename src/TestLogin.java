import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestLogin {

	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("https://offerupnow.com/");
	}

	// Given that I have a right account and a right password
	// When I log into the website
	// Then I see that the logout button displays in the page.
	@Test
	public void RightLoginTest() {

		driver.findElement(By.id("login")).click();
		// Enter username "lanzhang.lemon@gmail.com", password "lzhang11"
		driver.findElement(By.id("id_login")).sendKeys(
				"zhanglan_mini@hotmail.com");
		driver.findElement(By.id("id_password")).sendKeys("Zhanglan");

		// Look for the login button (in the login div) and click to login
		WebElement submitButton = driver.findElement(By
				.xpath("//*[@id='login-form']/div[3]/input"));
		submitButton.click();

		// Check whether or not it login successfully, if successful, the logout
		// button should show
		try {
			// WebElement logoutButton = driver.findElement(By
			// .cssSelector("a[href='/comet/logout.do']"));
			assertTrue(driver.getTitle().contains("My Offers"));
			// Create action class object
			Actions builder=new Actions(driver);
			WebElement nametag=driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/a"));
			builder.moveToElement(nametag).perform();
			if(driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/div/ul/li[7]/a")).isDisplayed()){ 
			    System.out.println("Logout button is coming"); 
			    driver.findElement(By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/div/ul/li[7]/a")).click();
			   }else{
				   System.out.println("No Logout button present");
			   }
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// Given that I have a right account and a wrong password
	// When I log into the website
	// Then I see that the statement of error displays in the page.
	@Test
	public void WrongPasswordTest() {

		driver.findElement(By.id("login")).click();
		// Enter username "lanzhang.lemon@gmail.com", password "lzhang11"
		driver.findElement(By.id("id_login")).sendKeys(
				"zhanglan_mini@hotmail.com");
		driver.findElement(By.id("id_password")).sendKeys("1111");

		// Look for the login button (in the login div) and click to login
		WebElement submitButton = driver.findElement(By
				.xpath("//*[@id='login-form']/div[3]/input"));
		submitButton.click();

		// Check whether or not it login successfully, if successful, the logout
		// button should show
		try {
			assertTrue(driver
					.findElement(By.cssSelector("div[class='errortext bold']"))
					.getText().contains("Error in submission"));
			driver.findElement(By.xpath("//*[@id='header-nav']/div/div[2]/div/ul/li[1]/a")).click();
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
		// Given that I have forgot my password and in the login page.
		// When I click the link to reset my password and type in my email.
		// Then I see that the successed statement displays in the page.
		@Test
		public void ForgetPasswordTest() {

			driver.findElement(By.id("login")).click();
			//Click the reset link and jump to the reset page.
			driver.findElement(By.xpath("//*[@id='login-form']/div[4]/a")).click();
			//Type the right account name into the input.
			driver.findElement(By.id("id_email")).sendKeys(
					"zhanglan_mini@hotmail.com");
			// Look for the send button and click to it.
			driver.findElement(By.xpath("//*[@id='password-reset-form']/form/div[2]/input")).click();

			try {
				assertTrue(driver
						.findElement(By.xpath("/html/body/div[5]/h1"))
						.getText().contains("We have emailed you your login info!"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}

}
