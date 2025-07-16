package GU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);//this keyword represent current class object.
	}
	@FindBy(xpath="//input[@name='account_name']/../..//img[@alt='Select']")
	private WebElement orglink;
	
	public WebElement getOrglink() {
		return orglink;
	}
	
	@FindBy(id="search_txt")
	private WebElement orgname;
	
	@FindBy(name="search")
	private WebElement searchorg;
	
//	@FindBy(xpath="//a[text()='teddy']")
	@FindBy(xpath="//a[text()='\\\"+orgName+\\\"']")
	private WebElement orgincintact;
	
	public WebElement getOrgincintact() {
		return orgincintact;
	}

	public WebElement getSearchorg() {
		return searchorg;
	}

	public WebElement getOrgname() {
		return orgname;
	}
	@FindBy(name="lastname")
	private WebElement contactNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	public WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement ebdDateEdt;
	
//	@FindBy(name="support_end_date")
//	private WebElement ebdDateEdt;
	
	
	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getContactNameEdt() {
		return contactNameEdt;
	}
	
	public void createContact(String lastName) {
		contactNameEdt.sendKeys(lastName);
		saveBtn.click();
		
	}
	public void createContact(String lastName,String startdate) {
		contactNameEdt.sendKeys(lastName);
		startDateEdt.sendKeys(startdate);
		saveBtn.click();
		
	}
	
	public void createContact(String lastName,String startdate,String enddate) {
		contactNameEdt.sendKeys(lastName);
		startDateEdt.sendKeys(startdate);
		ebdDateEdt.clear();
		ebdDateEdt.sendKeys(enddate);
		saveBtn.click();
		
	}
	
	
	public WebElement getEbdDateEdt() {
		return ebdDateEdt;
	}

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
}
