package GU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);//this keyword represent current class object.
			
	}
    @FindBy(id="dtlview_Last Name")
    private WebElement ContactInfo;
    
    @FindBy(id="mouseArea_Organization Name")
    private WebElement orgname;
	
	public WebElement getOrgname() {
		return orgname;
	}


	public WebElement getContactInfo() {
		return ContactInfo;
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateType1;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement endDateType;
	
	
	public WebElement getStartDateType() {
		return startDateType1;
	}


	public WebElement getEndDateType() {
		return endDateType;
	}


	public WebElement getHeaderMsg1() {
		return headerMsg;
	}


	public WebElement getHeaderMsg() {
		// TODO Auto-generated method stub
		return null;
	}
}
