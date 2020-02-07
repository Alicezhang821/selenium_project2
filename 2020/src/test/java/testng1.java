
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class testng1 {
	public WebDriver webDriver;

	@BeforeTest
	public void beforeTest() {

	}

	@Test
	@Parameters({ "name", "pw" })
	public void f(String name, String pw) throws IOException {
		System.setProperty("webdriver.firefox.bin", "C:\\40\\firefox.exe");
		// System.setProperty("webdriver.gecko.driver", "C:\\NEW\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		webDriver = new FirefoxDriver(options);
		String baseUrl = "http://www.demo.guru99.com/V4/";

		webDriver.get(baseUrl);
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement username = webDriver.findElement(By.xpath("//input[@name='uid']"));
		WebElement password = webDriver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys(name);
		// password.sendKeys("bYpAjuz");
		password.sendKeys(pw);
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

		username = webDriver.findElement(By.xpath("//input[@name='uid']"));
		password = webDriver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys("mngr243785");
		// password.sendKeys("bYpAjuz");
		password.sendKeys("bYpAjuz");
		button = webDriver.findElement(By.xpath("//input[@name='btnLogin']"));
		button.click();

		String actualTitle = webDriver.getTitle();
		String expectedTitle = "Guru99 Bank Manager HomePage";

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test2 Passed!");
		} else {
			System.out.println("Test2 Failed");
		}

		String uid = webDriver.findElement(By.xpath("//td[contains(text(),'Manger Id :')]")).getText();
		System.out.println(uid);
		String news = "Manger Id : " + name;
		System.out.println(news);
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(webDriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("c:\\abc\\ElementScreenshot.jpg"));
		if (uid.contentEquals(news)) {
			System.out.println("Test3 Passed!");
		} else {
			System.out.println("Test3 Failed");
		}

	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}

}
