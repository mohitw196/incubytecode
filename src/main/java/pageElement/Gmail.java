package pageElement;

import org.testng.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {
	public static WebDriver driver = null;

	public Gmail() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get("http://www.gmail.com/");
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	}
	
	public void userLogin(String id, String pass) throws Exception {
		
		driver.findElement(By.id("identifierId")).sendKeys(id);
		driver.findElement(By.xpath("//button/span[text()='Next']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button/span[text()='Next']")).click();	
		Thread.sleep(4000);
	}
	
	public void verifyComposeButtonPresent() throws Exception {
		boolean flag = driver.findElement(By.xpath("//div[text()='Compose']")).isDisplayed();
		Assert.assertTrue(flag);
		driver.close();
	}

	public void enterRecipients() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("Dummy@gmail.com");
	}

	public void clickSendButton() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(500);
		
	}

	public void verifyPopUpDisplayed(String string) throws Exception {
		int size = driver.findElements(By.xpath("//span[text()='"+ string +"']")).size();
		Assert.assertTrue(size >0,"Message is Sent");
		driver.close();
	}

	public void enterBody(String string) throws Exception {
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(string);
		
	}

	public void enterSubject(String string) throws Exception {
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(string);
		
	}

	public void clickComposeButton() throws Exception {
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(2000);
	}

}
