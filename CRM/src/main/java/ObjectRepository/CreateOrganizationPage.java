package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement accountname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveOrganization;
	
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typedropdown;
	
	@FindBy(id = "phone")
	private WebElement phoneno;

	public WebElement getAccountname() {
		return accountname;
	}

	public WebElement getSaveOrganization() {
		return saveOrganization;
	}

	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}

	public WebElement getPhoneno() {
		return phoneno;
	}
	
}
