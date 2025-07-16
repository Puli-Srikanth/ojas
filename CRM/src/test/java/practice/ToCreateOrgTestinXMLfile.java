package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ToCreateOrgTestinXMLfile {

	@Test
	public void sampleTest(XmlTest test) {
		
		String browser=test.getParameter("browser");
		String url=test.getParameter("url");
		String username=test.getParameter("username");
		String password=test.getParameter("password");
		
	WebDriver driver = null;
	if(browser.equals("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	}
	else {
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get(url);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	Random r = new Random();
	int random = r.nextInt(1000);
	driver.findElement(By.name("accountname")).sendKeys("teddy"+random);
	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	String accountname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(accountname.contains("teddy"+random)) {
		System.out.println(accountname + "-----Passed");
	} else {
		System.out.println(accountname + "-----Failed");
	}
	
	WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions action = new Actions(driver);
	action.moveToElement(logoutEle).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();

}
}
