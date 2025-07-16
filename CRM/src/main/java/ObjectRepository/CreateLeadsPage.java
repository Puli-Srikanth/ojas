package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsPage {

	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement leadname;
	
	@FindBy(name = "company")
	private WebElement company;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveLeads;

	public WebElement getLeadname() {
		return leadname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getSaveLeads() {
		return saveLeads;
	}

	public WebElement getPhone() {
		return phone;
	}
	
}
