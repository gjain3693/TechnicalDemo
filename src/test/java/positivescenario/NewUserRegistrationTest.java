package positivescenario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import runner.TestSuite;

/**
 * This class has New user registration scenario.
 * @author Gjain
 *
 */
public class NewUserRegistrationTest {

	WebDriver driver = TestSuite.webDriver;

	String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());


	/**
	 * This method will register new user. 
	 * @param userName will contain user name for registration.
	 * @param password will contain password for registration.
	 * @param email will contain email id of user need for registration.
	 */

	@Test
	public  void registerUser() {

		String userName = "Gaurav Jain" + date;
		String password = "Ins24me*";
		String email = "nicks4uever1@gmail.com";

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='confirmationPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id='registrationForm']"
				+ "/fieldset/div[5]/button")).click();

		WebElement webTable = driver.findElement(By.xpath("//*[@id='users']"));
		String expectedUserName;
		List<WebElement> totalRows = webTable.findElements(By.xpath("//*[@id='users']"
				+ "/tbody/tr"));
		int rowIndex = 1;
		for (WebElement rowElement:totalRows) {

			List<WebElement> columnCount = rowElement.findElements(By.xpath("td"));
			int columnIndex = 1;
			for (WebElement colElement: columnCount) {
				expectedUserName = colElement.getText();
				if (expectedUserName.equalsIgnoreCase(userName)) {

					System.out.println("NEW USER REGISTERED SUCCESSFULLy");
					
				} else {
					columnIndex = columnIndex + 1;	
				}

			}

			rowIndex = rowIndex + 1;
		}

		String expectedPageName = "All User";

		String actualPageName = driver.findElement(By.xpath("//div[@class='page-header']"
				+ "/h1")).getText();

		Assert.assertEquals(expectedPageName, actualPageName);

		driver.navigate().back();
	}


}
