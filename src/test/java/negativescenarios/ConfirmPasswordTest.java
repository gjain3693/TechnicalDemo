package negativescenarios;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import runner.TestSuite;

/**
 * This class has Confirm password and password equality scenario.
 * @author Gjain
 *
 */

public class ConfirmPasswordTest {
	
	String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	WebDriver driver = TestSuite.webDriver;

	/**
	 * This method will verify password and confirm password same or not.
	 * This method will verify error message when confirm password and password not same.
	 * @userName will contain user name for registration.
	 * @password will contain password for registration.
	 * @email will contain email id of user for registration.
	 */
	
	@Test
	public  void enterDifferentConfirmPasswordValue() {

		String userName = "alex" + date;
		String password = "123456";
		String confirmPassword = "12345";
		String email = "alex@mail.com";
		String errorMessage = "passwords are not the same";
		String actualErrorMessage;

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']"))
		.sendKeys(confirmPassword);

		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		actualErrorMessage = driver.findElement(By.xpath(
				"//*[@id='user.confirmationPassword.error']")).getText();

		Assert.assertEquals(errorMessage, actualErrorMessage);

		driver.navigate().refresh();
	}


}
