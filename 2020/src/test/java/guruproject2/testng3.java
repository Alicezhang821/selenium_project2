package guruproject2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng3 {
	public WebDriver webDriver;

	@BeforeTest
	public void beforeTest() {

	}

	@Test
	public void test() throws IOException {
		System.setProperty("webdriver.firefox.bin", "C:\\40\\firefox.exe");
		// System.setProperty("webdriver.gecko.driver", "C:\\NEW\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		webDriver = new FirefoxDriver(options);
		String baseUrl = "http://live.demoguru99.com/";

		webDriver.get(baseUrl);
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String actualTitle = webDriver.getTitle();
		String expectedTitle = "Home page";

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test1 Passed!");
		} else {
			System.out.println("Test1 Failed");
		}

		String biaotitrue = "THIS IS DEMO SITE FOR   ";

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement title = webDriver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]"));
		String biaoti = title.getText();
		System.out.println(biaoti);
		System.out.println(biaotitrue);
		if (biaoti.contentEquals(biaotitrue)) {
			System.out.println("Test2 Passed!");
		} else {
			System.out.println("Test2 Failed");
		}

		WebElement link = webDriver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		link.click();

		String mobiletitle = "MOBILE";

		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement mobilepage = webDriver.findElement(By.xpath("//h1[contains(text(),'Mobile')]"));
		String mobiletitletrue = mobilepage.getText();

		if (mobiletitle.contentEquals(mobiletitletrue)) {

			System.out.println("Test3 Passed!");
		} else {
			System.out.println("Test3 Failed");
		}

		Select drop = new Select(webDriver.findElement(By.xpath(
				"//body[contains(@class,'catalog-category-view categorypath-mobile-html category-mobile')]/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")));
		drop.selectByVisibleText("Name");

	}

	@AfterTest
	public void afterTest() {
		// webDriver.close();
	}

}
