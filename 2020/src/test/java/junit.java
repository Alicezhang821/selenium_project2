import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author Alice Zhang
 * @version created on：30 Jan 2020 1:36:19 pm Description
 */
public class junit {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		System.setProperty("webdriver.firefox.bin", "C:\\40\\firefox.exe");
		// System.setProperty("webdriver.gecko.driver", "C:\\NEW\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		WebDriver webDriver = new FirefoxDriver(options);
		String baseUrl = "http://www.demo.guru99.com/V4/";

		webDriver.get(baseUrl);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement username = webDriver.findElement(By.xpath("//input[@name='uid']"));
		WebElement password = webDriver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys("mngr243785");
		// password.sendKeys("bYpAjuz");
		password.sendKeys("bYpAjuzx");
		WebElement button = webDriver.findElement(By.xpath("//input[@name='btnLogin']"));
		button.click();

		String errormessage = webDriver.switchTo().alert().getText();
		String realmessage = "User or Password is not valid";
		if (errormessage.contentEquals(realmessage)) {
			System.out.println("Test1 Passed!");
		} else {
			System.out.println("Test1 Failed");
		}
		webDriver.switchTo().alert().accept();

//		String actualTitle = webDriver.getTitle();
//		String expectedTitle = "Guru99 Bank Manager HomePage";
//		
//		if (actualTitle.contentEquals(expectedTitle)) {
//			System.out.println("Test Passed!");
//		} else {
//			System.out.println("Test Failed");
//		}

		// close Fire fox
		// webDriver.close();

	}

}
