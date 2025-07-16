package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement contactname;
	
	@FindBy(xpath = "//input[@name='account_name']/../..//img[@alt='Select']")
	private WebElement orglink;
	
	@FindBy(id = "search_txt")
	private WebElement orgname;
	
	@FindBy(name = "search")
	private WebElement searchorg;
	
	//@FindBy(xpath = "//a[text()='teddy']")
	//private WebElement orgincontact;
	
	@FindBy(name = "support_start_date")
	private WebElement startDate;
	
	@FindBy(name = "support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveContact;

	public WebElement getContactname() {
		return contactname;
	}
	
	public WebElement getOrglink() {
		return orglink;
	}
	
	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSearchorg() {
		return searchorg;
	}


	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getSaveContact() {
		return saveContact;
	}
	
}
