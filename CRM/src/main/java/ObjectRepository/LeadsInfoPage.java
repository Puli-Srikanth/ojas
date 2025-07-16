package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {

	public LeadsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement LeadInfo;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneinfo;

	public WebElement getLeadInfo() {
		return LeadInfo;
	}

	public WebElement getPhoneinfo() {
		return phoneinfo;
	}

}
