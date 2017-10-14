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
 *This class has unique email constraint scenario. 
 * @author Gjain
 *
 */

public class EmailUniqueConstraintTest {
	
	WebDriver driver = TestSuite.webDriver;
	String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

	/**
	 * This method will verify unique email id scenario.
	 * This method will verify error message when duplicate registration
	 * attempted with duplicate email id.	
	 * @userName will contains user name for registration.
	 * @password will contains password for registration.
	 * @email will contain duplicate email id for registration.
	 */
	
	@Test
	public  void registerUserWithDuplicateEmail() {

		String userName = "alex" + date;
		String password = "Ins24me*";
		String email = "alex2@gmail.com";
		String actualErrorMessage;
		String errorMessage;

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		errorMessage = "Must be unique";


		actualErrorMessage = driver.findElement(By.xpath(
				"//*[@id='user.email.error']")).getText();

		Assert.assertEquals(errorMessage, actualErrorMessage);

		driver.navigate().refresh();
	}



}
