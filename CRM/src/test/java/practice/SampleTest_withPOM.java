package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTest_withPOM {

	@FindBy(name = "user_name")
	WebElement user;
	
	@FindBy(name = "user_password")
	WebElement pass;
	
	@FindBy(id = "submitButton")
	WebElement log;
	
	@Test
	public void sampleTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8888/");
		
		SampleTest_withoutPOM s=PageFactory.initElements(driver, SampleTest_withoutPOM.class);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		Thread.sleep(10000);
		driver.navigate().refresh();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}
}
