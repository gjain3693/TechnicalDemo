package runner;


import negativescenarios.AllMandateValuesNotEnteredTest;
import negativescenarios.ConfirmPasswordTest;
import negativescenarios.EmailNotEnteredTest;
import negativescenarios.EmailUniqueConstraintTest;
import negativescenarios.NameNotEnteredTest;
import negativescenarios.NameUniqueConstraintTest;
import negativescenarios.PasswordNotEnteredTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import positivescenario.NewUserRegistrationTest;

/**
 * This is test suite which contains test classes.
 * 
 * @author Gjain
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	NewUserRegistrationTest.class,
	AllMandateValuesNotEnteredTest.class,
	EmailNotEnteredTest.class,
	NameNotEnteredTest.class,
	PasswordNotEnteredTest.class,
	EmailUniqueConstraintTest.class,
	NameUniqueConstraintTest.class,
	ConfirmPasswordTest.class
	
	
	
	
	
})

/**
 * This class will contain webdriver initialization and activities
 *  related after test execution completion.
 * @author Gjain
 *
 */

public class TestSuite {
	public static WebDriver webDriver;
	
	/**
	 * This method will initalize webdriver and 
	 * perform pre-requisite activities before execution of test cases.
	 */
	
	@BeforeClass
	public static void initalizeBrowser() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("http://85.93.17.135:9000/user/new");
				
	}
	
	/**
	 * This method will close all browser after all test execution completed.
	 * @throws InterruptedException  when a thread is waiting, sleeping, or otherwise occupied,
	 * and the thread is interrupted, either before or during the activity
	 */
	
	@AfterClass
	public static void  closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		webDriver.quit();
	}

}
