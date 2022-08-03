package ass2W9D4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;

public class ChromeWebDriverAss2W9D4 {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 * 
	 * @throws InterruptedException
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver");
		System.out.println(driver.getTitle());
		Thread.sleep(5000); // waiting for the elements to load and be visible to use

	}

	/**
	 * Test retrieve data using web Crawler
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {

		// Read page content
		String content = driver.getPageSource();

		// Print the page content
		System.out.println(content);

		// Find the table element using xpath
		WebElement table = driver.findElement(By.xpath("//table[@class='grid versions']"));
//		Thread.sleep(3000);

		// Go through each major version
		List<WebElement> mainVersions = table.findElements(By.tagName("tbody"));

		for (WebElement mver : mainVersions) {
			for (WebElement ver : mver.findElements(By.tagName("tr"))) {
				// Get all anchor tags
				List<WebElement> attributes = ver.findElements(By.tagName("a"));

				// Find each relevant web element that contains required information
				WebElement version = attributes.get(0);
				WebElement repository = attributes.get(1);
				WebElement usages = attributes.get(2);
				WebElement date = Iterables.getLast(ver.findElements(By.tagName("span")));

				System.out.println("Version    : " + version.getText());
				System.out.println("Repository : " + repository.getText());
				System.out.println("Usages     : " + usages.getText());
				System.out.println("Date       : " + date.getText());
				System.out.println("------------------------------");
			}
		}
//		Thread.sleep(3000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.close();

		// Quite the selenium
		driver.quit();
	}
}
