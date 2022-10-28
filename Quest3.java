package SeleniumExercise2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Quest3 {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anurag Pandey\\eclipse-workspace\\anurag\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	// ------------- HOME PAGE Test Cases---------------------
	@Test(priority = 1)
	public void verifyUrl() {
		// Verify the homePage url & current title page
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.amazon.in/";
		try {
			Assert.assertEquals(currentUrl, expectedUrl);
		} catch (Exception e) {
			System.out.println("--Url mismatched--");
		}
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (Exception e) {
			System.out.println("Title mismatched");
		}
	}

	@Test(priority = 2)
	public void amazonSearch() {
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
		driver.findElement(By.xpath("(//span[@class=\"nav-line-2\"])[3]")).click();
	}

}
