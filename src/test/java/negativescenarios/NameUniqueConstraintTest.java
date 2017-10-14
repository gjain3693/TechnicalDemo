package negativescenarios;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import runner.TestSuite;

/**
 * This class has user name unique constraint scenario.
 * @author Gjain
 *
 */

public class NameUniqueConstraintTest {
	
WebDriver driver = TestSuite.webDriver;
	
	/**
	 * This method will attempt registration with existing user name.
	 * This method will verify error message for duplicate user name.  
	 * @userName will contain existing user name for registration.
	 * @password will contain password for registration.
	 * @email will contain email id of user for registration.
	 */
	
	@Test
	public  void registerUserWithDuplicateName() {
		
		String userName = "alex2";
		String password = "Ins24me*";
		String email = "alicia@mail.com";
		String errorMessage;
		String actualErrorMessage;
		
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();
		
		errorMessage = "Must be unique";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		actualErrorMessage = driver.findElement(By.xpath(
				"//*[@id='user.name.error']")).getText();
		
		Assert.assertEquals(errorMessage, actualErrorMessage);
		
		driver.navigate().refresh();
	}


}
