package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneinfo;
	
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getPhoneinfo() {
		return phoneinfo;
	}
	
	
}
