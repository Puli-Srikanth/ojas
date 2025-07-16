package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void getImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void getExplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void toSwitchWindow(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String title = driver.switchTo().window(id).getTitle();
			if(title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void toSwitchBetweenWindowThroughIndex(WebDriver driver,int index) {
		Set<String> wins=driver.getWindowHandles();
		int ct=0;
		for(String t:wins) {
			driver.switchTo().window(t);
			ct++;
			if(ct==index)
				break;		
		}
	}
	
	public void toHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void toHandleFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}
	
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void toHandleBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void toSwitchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void toSwitchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void toSwitchToAlertAndCaptureMessage(WebDriver driver) {
		Alert alertPopup = driver.switchTo().alert();
		String message = alertPopup.getText();
		alertPopup.accept();
		//return message;
	}
	
	public void toHandleDropdown(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		}
		
	public void toHandleDropdown(WebElement element,String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}
		
	public void toHandleDropdown(String value,WebElement element) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		}
	
	public void toMouseHover(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void toRightClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}
	
	public void toTakeScreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/" + screenshotname + ".png");
		FileHandler.copy(temp,src);
	}
	
	public void toHandleJSinScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void toHandleJSinScrollTo(WebDriver driver, int x_cord, int y_cord) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(arguments[0], arguments[1])", x_cord, y_cord);
	}

	public void toHandleJSinScrollBy(WebDriver driver, int x_cord, int y_cord) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1])", x_cord, y_cord);
	}
	
}
