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
 * This class has No password entered scenario.
 * @author Gjain
 *
 */

public class PasswordNotEnteredTest {
	
	WebDriver driver = TestSuite.webDriver;
	String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	
	/**
	 * This method will attempt to register user without entering password.
	 * This method will verify error message received when no password entered. 
	 * @userName will contain name of user for registration.
	 * @email will contain email id of user for registration.
	 */
	
	@Test
	public  void setNoPassword() {
		
		String userName = "Gaurav Jain" + date;
		String email = "nicks4uever@gmail.com";
		String errorForPassword;
		String expectedError;
		
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		errorForPassword = driver.findElement(By.xpath(
				"//*[@id='user.password.error']")).getText();
		expectedError = "Required";
		Assert.assertEquals(expectedError, errorForPassword);
		
		driver.navigate().refresh();
	}


}
