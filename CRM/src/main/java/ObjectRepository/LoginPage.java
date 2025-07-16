package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name")
	private WebElement user;
	
	@FindBy(name = "user_password")
	private WebElement pass;
	
	@FindBy(id = "submitButton")
	private WebElement log;

	public WebElement getUser() {
		return user;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLog() {
		return log;
	}
	public void login(String username, String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
		log.click();
	}
}
