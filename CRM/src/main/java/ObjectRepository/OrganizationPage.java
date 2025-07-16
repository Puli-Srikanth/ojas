package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	@FindBy(name = "search_text")
	private WebElement searchorg;
	
	@FindBy(name = "search_field")
	private WebElement selectorg;
	
	@FindBy(name = "submit")
	private WebElement searchbtn;
	
	public WebElement getCreateOrganization() {
		return createOrganization;	
	}

	public WebElement getSearchorg() {
		return searchorg;
	}

	public WebElement getSelectorg() {
		return selectorg;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
}
