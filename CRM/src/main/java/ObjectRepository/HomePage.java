package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement org;
	
	@FindBy(linkText = "Contacts")
	private WebElement contact;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText = "More")
	private WebElement more;
	
	@FindBy(linkText = "Leads")
	private WebElement leads;
	
	@FindBy(linkText = "Products")
	private WebElement products;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeIcon;
	
	@FindBy(xpath = "//table/descendant::td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	public WebElement getOrg() {
		return org;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getMore() {
		return more;
	}
		
	public WebElement getLeads() {
		return leads;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	
	public void clickMore() {
		Actions a = new Actions(driver);
		a.moveToElement(more).perform();
		campaign.click();
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.moveToElement(admin).perform();
		signout.click();
	}
}
