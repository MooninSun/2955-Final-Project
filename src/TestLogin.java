import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * As a user, I would like to login the website. So I can get personal service.
 * 
 */

public class TestLogin {

	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("https://offerupnow.com/");
	}

	// Given that I have a right account and a right password
	// When I log into the website
	// Then I see that the title of page changed.
	@Test
	public void RightLoginTest() {

		driver.findElement(By.id("login")).click();
		// Enter username "lanzhang.lemon@gmail.com", password "lzhang11"
		driver.findElement(By.id("id_login")).sendKeys(
				"zhanglan_mini@hotmail.com");
		driver.findElement(By.id("id_password")).sendKeys("Zhanglan");

		// Look for the login button and click to login
		WebElement submitButton = driver.findElement(By
				.xpath("//*[@id='login-form']/div[3]/input"));
		submitButton.click();

		// Check whether or not it login successfully, if successful, the title
		// of
		// this page will change.
		try {
			assertTrue(driver.getTitle().contains("My Offers"));
			// We need to logout first to operate other test cases.
			// Create action class object
			Actions builder = new Actions(driver);
			// find the target object and trigger the mouseover() function
			WebElement nametag = driver
					.findElement(By
							.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/a"));
			builder.moveToElement(nametag).perform();
			// When the logout button show up
			// click on it.
			if (driver
					.findElement(
							By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/div/ul/li[7]/a"))
					.isDisplayed()) {
				System.out.println("Logout button is coming");
				driver.findElement(
						By.xpath("//*[@id='header-nav']/div[2]/div[3]/div/div/ul/li[2]/div/ul/li[7]/a"))
						.click();
			} else {
				System.out.println("No Logout button present");
			}
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

//	 Given that I have a right account and a wrong password
//	 When I log into the website
//	 Then I see that the statement of error displays in the page.
	@Test
	public void WrongPasswordTest() {

		driver.findElement(By.id("login")).click();
		// Enter the right email.
		driver.findElement(By.id("id_login")).sendKeys(
				"zhanglan_mini@hotmail.com");
		// Enter the wrong password.
		driver.findElement(By.id("id_password")).sendKeys("1111");

		// Look for the submit button (in the login div) and click to login
		WebElement submitButton = driver.findElement(By
				.xpath("//*[@id='login-form']/div[3]/input"));
		submitButton.click();

		// The error statement will be showed up in the page
		try {
			assertTrue(driver
					.findElement(By.cssSelector("div[class='errortext bold']"))
					.getText().contains("Error in submission"));
			driver.findElement(
					By.xpath("//*[@id='header-nav']/div/div[2]/div/ul/li[1]/a"))
					.click();
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

//	 Given that I have forgot my password and in the login page.
//	 When I click the link to reset my password and type in my email.
//	 Then I see that the success statement displays in the page.
	@Test
	public void ForgetPasswordTest() {

		driver.findElement(By.id("login")).click();
		// Click the reset link and jump to the reset page.
		driver.findElement(By.xpath("//*[@id='login-form']/div[4]/a")).click();
		// Type the right account name into the input.
		driver.findElement(By.id("id_email")).sendKeys(
				"zhanglan_mini@hotmail.com");
		// Look for the send button and click to it.
		driver.findElement(
				By.xpath("//*[@id='password-reset-form']/form/div[2]/input"))
				.click();

		// The success statement will display
		try {
			assertTrue(driver.findElement(By.xpath("/html/body/div[5]/h1"))
					.getText().contains("We have emailed you your login info!"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
