package practice;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion_HomePageTest {

	@Test
	public void homepage(Method mtd) {
		
		System.out.println(mtd.getName()  + "test start");
		String expectedpage = "Home";
		
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("http://49.249.28.218:8888/");
				
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				String title = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
				//Hard Assert
				Assert.assertEquals(title, expectedpage);
				/*if(title.trim().equals(expectedpage)) {
					System.out.println(expectedpage + "page is verified-->PASS");
				} else {
					System.out.println(expectedpage + "page is not verified-->FAIL");
				}*/
				
				driver.close();
				System.out.println(mtd.getName()  + "test end");
	}
	
	@Test
	public void verifylogo(Method mtd) {
		System.out.println(mtd.getName()  + "test start");
		
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("http://49.249.28.218:8888/");
				
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
				//Hard Assert
				Assert.assertTrue(status);
				/*if(status) {
					System.out.println("Logo is verified-->PASS");
				} else {
					System.out.println("Logo is not verified-->FAIL");
				}*/
				driver.close();
				System.out.println(mtd.getName()  + "test end");
				}
				
	}
