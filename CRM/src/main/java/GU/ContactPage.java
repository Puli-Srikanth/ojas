package GU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);//this keyword represent current class object.
			
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateNewContactBtn;
	
	public WebElement getCreateNewContactBtn() {
		return CreateNewContactBtn;
	}

	public WebElement getCreateContact() {
		// TODO Auto-generated method stub
		return null;
	}
}
