package negativescenarios;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import runner.TestSuite;

/**
 * This class will verify mandate values entries scenario.
 * @author Gjain
 *
 */

public class AllMandateValuesNotEnteredTest {
	
WebDriver driver = TestSuite.webDriver;
	
	
	/**
	 * This method will leave blank all mandate values and attempt to register user.
	 * This method will verify error message when mandate values leave as blank.
	 * @userName will not contain any user name to enter.
	 * @password will not contain any password to enter.
	 * @email will not contain any email id to enter.
	 */
	
	@Test
	public void noMandateValueEntered() {

		String userName = "";
		String password = "";
		String email = "";
		String errorForName;
		String errorForEmail;
		String errorForPassword;
		String expectedError;

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		errorForName = driver.findElement(By.xpath("//*[@id='user.name.error']")).getText();
		errorForEmail = driver.findElement(By.xpath("//*[@id='user.email.error']"))
				.getText();
		errorForPassword = driver.findElement(By.xpath("//*[@id='user.password.error']"))
				.getText();

		expectedError = "Required";

		Assert.assertEquals(expectedError, errorForName);
		Assert.assertEquals(expectedError, errorForEmail);
		Assert.assertEquals(expectedError, errorForPassword);
		
		driver.navigate().refresh();


	}


}
