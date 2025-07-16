package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productname;
	
	@FindBy(name = "productcategory")
	private WebElement categorydropdown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveProducts;
	
	public WebElement getProductname() {
		return productname;
	}

	public WebElement getCategorydropdown() {
		return categorydropdown;
	}

	public WebElement getSaveProducts() {
		return saveProducts;
	}
	
}
