package SeleniumExercise2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

        public class Ques1 {
            public WebDriver driver;

            @BeforeClass
            public void launchBrowser() {
            	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Anurag Pandey\\eclipse-workspace\\anurag\\src\\test\\resources\\chromedriver.exe");
                 driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            }

            @Test(priority = 1)
            public void fetchingAlertPopUpTextAndDismissTset() {
                driver.findElement(By.id("confirmbtn")).click();
                Alert obj = driver.switchTo().alert();
                System.out.println(obj.getText());
                obj.dismiss();
            }

            @Test(priority=2)
            public void enterDataInAlertPopUpTset() {
                driver.findElement(By.id("name")).sendKeys("Anurag");
                driver.findElement(By.id("alertbtn")).click();
                Alert obj2 = driver.switchTo().alert();
                System.out.println(obj2.getText());
                obj2.accept();
            }
        }
          