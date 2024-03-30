package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LeanExceptions {

	WebDriver Driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().deleteAllCookies();
		Driver.get("https://codefios.com/ebilling/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin() {
		// ELEMENT LIST - WebElement type
		WebElement USER_NAME_ELEMENT = Driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD_ELEMENT = Driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = Driver.findElement(By.xpath("//button[@id='login_submit']"));
		
		// ELEMENT LIST - By type
		By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
		
		By DASHBOARD_VALIDATION_FIELD = By.xpath("//html/body/div[1]/section/div/div[2]/div/div/header/div/strong");

		USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123a");
		SIGNIN_BUTTON_ELEMENT.click();
		WebDriverWait wait = new WebDriverWait(Driver, 20);
		//Explicit wait
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_VALIDATION_FIELD));		
		WebElement DASHBOARD_VALIDATION_ELEMENT = Driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));

		Assert.assertTrue("Dashboard page not found", DASHBOARD_VALIDATION_ELEMENT.isDisplayed());
	}

}
