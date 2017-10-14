package negativescenarios;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import runner.TestSuite;


/**
 * This class has no user name scenario.
 * @author Gjain
 *
 */

public class NameNotEnteredTest {
	
	WebDriver driver = TestSuite.webDriver;

	/**
	 *This method will attempt registration without user name.
	 * @password will contain password for registration.
	 * @email will contain email id of user for registration.
	 */

	@Test
	public  void setNoUserName() {

		String password = "Ins24me*";
		String email = "nicks4uever@gmail.com";
		String errorForUserName;
		String expectedError;

		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		errorForUserName = driver.findElement(By.xpath(
				"//*[@id='user.name.error']")).getText();
		expectedError = "Required";

		Assert.assertEquals(expectedError, errorForUserName);

		driver.navigate().refresh();
	}


}
