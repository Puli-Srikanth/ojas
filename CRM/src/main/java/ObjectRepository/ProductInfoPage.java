package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductInfo;
	
	@FindBy(id = "mouseArea_Product Category")
	private WebElement CategoryInfo;

	public WebElement getProductInfo() {
		return ProductInfo;
	}

	public WebElement getCategoryInfo() {
		return CategoryInfo;
	}
	
}
