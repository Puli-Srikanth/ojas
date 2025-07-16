package GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public DataBaseUtility dbutil = new DataBaseUtility();
	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();
	
	public WebDriver driver = null;

	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)//(groups = {"smoke" , "regression"})
	public void configBS() throws SQLException {
		System.out.println("---Connect to DB , Report Config---");
		dbutil.getDataBaseConnection();
		
	}
	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)//(groups = {"smoke" , "regression"})
	public void configBC(/*String Browser*/) throws Throwable {
		System.out.println("---Launch the browser---");
		//String browser = Browser;
		String browser = futil.getDataFromPropertyFile("browser");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		wutil.toMaximize(driver);
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(alwaysRun = true)//(groups = {"smoke" , "regression"})
	public void configBM() throws Throwable {
		System.out.println("---login---");
		String url = futil.getDataFromPropertyFile("URL");
		System.out.println(url);
		String username = futil.getDataFromPropertyFile("username");
		String password = futil.getDataFromPropertyFile("password");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		
	}
	
	@AfterMethod(alwaysRun = true)//(groups = {"smoke" , "regression"})
	public void configAM() throws Throwable {
		System.out.println("---logout---");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(alwaysRun = true)//(groups = {"smoke" , "regression"})
	public void configAC() {
		System.out.println("---Close the browser---");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)//(groups = {"smoke" , "regression"})
	public void configAS() throws Throwable {
		System.out.println("---close DB , Report backup---");
		dbutil.closeDBconnection();
	}
	
}
