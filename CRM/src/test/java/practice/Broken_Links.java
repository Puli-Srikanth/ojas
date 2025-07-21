package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Broken_Links {

	@Test
	public void handlebroken() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.onlinesbi.sbi/");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		
		for (WebElement eachLink : allLinks) {
			String link = eachLink.getAttribute("href");
			try {
				URL url = new URL(link);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				int statuscode = conn.getResponseCode();
				if(statuscode>=400) {
					System.out.println(link+"==>"+statuscode);
				}
			} catch (Exception e) {
			
			}
		}
		driver.quit();
	}
}
