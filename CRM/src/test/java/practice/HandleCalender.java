package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandleCalender {

	@Test
	public void goibiboTest() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		
		/*driver.findElement(By.xpath("//span[.='From']")).sendKeys("mumbai");
		
		driver.findElement(By.xpath("//span[.='To']")).sendKeys("goa");
		driver.findElement(By.xpath("//span[.='Departure']")).click(); */
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Week']/descendant::div[@aria-label='Wed Jan 14 2026']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}
	
	@Test
	public void redbus() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//span[.='Date of Journey']")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//i[@class='icon icon-arrow arrow___4df7ff right___90a032 ']")).click();
			}
		}
	}
	
	@Test
	public void irctc() throws Throwable  {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		WebElement ele1=driver.findElement(By.xpath("(//input[@role='searchbox'])[1]"));
		ele1.sendKeys("BENGALURU CANT - BNC");
		driver.findElement(By.xpath(" //span[contains(text(),'BENGALURU CANT - BNC')] ")).click();
		
		WebElement ele2=driver.findElement(By.xpath("(//input[@role='searchbox'])[2]"));
		ele2.sendKeys("HYDERABAD DECAN - HYB");
		driver.findElement(By.xpath("//span[contains(text(),' HYDERABAD DECAN - HYB ')]")).click();
		
		driver.findElement(By.xpath("//p-calendar[@id='jDate']")).click();
		driver.findElement(By.xpath("//a[text()='30']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		
	}
	
	@Test
	public void ksrtc() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ksrtc.in/");
		
	}
	
	@Test
	public void makemytrip() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).click();
		
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-2']")).click();
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Week']/descendant::div[@aria-label='Sat Aug 09 2025']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		driver.findElement(By.xpath("//span[.='Return']")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Week']/descendant::div[@aria-label='Sun Aug 31 2025']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-4']")).click();
		driver.findElement(By.xpath("//li[@data-cy='children-0']")).click();
		driver.findElement(By.xpath("//li[@data-cy='infants-0']")).click();
		driver.findElement(By.xpath("//li[@data-cy='travelClass-2']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
	}
	
}

