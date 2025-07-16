package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement ContactInfo;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement StartDateInfo;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement EndDateInfo;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgname;

	public WebElement getContactInfo() {
		return ContactInfo;
	}

	public WebElement getStartDateInfo() {
		return StartDateInfo;
	}

	public WebElement getEndDateInfo() {
		return EndDateInfo;
	}

	public WebElement getOrgname() {
		return orgname;
	}
	
}
