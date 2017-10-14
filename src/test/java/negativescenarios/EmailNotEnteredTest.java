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
 *This class has no email entered scenario.
 * @author Gjain
 *
 */

public class EmailNotEnteredTest {
	
	WebDriver driver = TestSuite.webDriver;
	String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

	/**
	 * This method will attempt to register user without email.
	 * This method will verify error message received when no email entered. 
	 * @userName will contain user name for registration.
	 * @password will contain password for registration.
	 */
	
	@Test
	public  void setNoEmail() {

		String userName = "Gaurav Jain" + date;
		String password = "Ins24me*";
		String errorForEmail;
		String expectedError;
		


		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		errorForEmail = driver.findElement(By.xpath("//*[@id='email']")).getText();
		expectedError = "Required";
		
		Assert.assertEquals(expectedError, errorForEmail);

		driver.navigate().refresh();
	}


}
