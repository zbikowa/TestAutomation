package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class presents a Page Object Pattern for Selenium WebDriver framework.
 * 
 * In order to execute the test case start a JPetStore app and provide its address if it is not on local host.
 * 
 * @author Mirek Rakowski <https://github.com/mirek-rakowski>
 * @see https://github.com/mirek-rakowski/TestAutomation
 * @see Wiki on <https://github.com/mirek-rakowski/TestAutomation/wiki> for more info.
 */
public class PageObject {

	// TODO: Here you have to provide a correct URL for the JPetStore app.
	private String URL = "http://localhost:8080/jpetstore/";
	
	// Section for page elements
	public static final By ENTER_LINK = By.linkText("Enter the Store");
	public static final By SIGN_IN_LINK = By.linkText("Sign In");
	public static final By SUBMIT = By.name("submit");
	public static final By REPTILES_LINK = By.xpath("//div[@id='QuickLinks']/a[3]/img");
	public static final By RATTLESNAKES_LINK = By.linkText("RP-SN-01");
	public static final By RATTLELESS_RATTLESNAKES_LINK = By.linkText("EST-12");

	public static final By CODE_CELL = By.xpath("//div[@id='Catalog']/table/tbody/tr[2]/td/b");
	public static final By SPECIES_CELL = By.xpath("//div[@id='Catalog']/table/tbody/tr[3]/td/b/font");
	public static final By GROUP_CELL = By.xpath("//div[@id='Catalog']/table/tbody/tr[4]/td");
	public static final By QUANTITY_CELL = By.xpath("//div[@id='Catalog']/table/tbody/tr[5]/td");
	public static final By PRICE_CELL = By.xpath("//div[@id='Catalog']/table/tbody/tr[6]/td");

	public static final By SIGN_OUT_LINK = By.linkText("Sign Out");
	public static final By HEADER_LABEL = By.xpath("//div[@id='MenuContent']/a[2]");

	RemoteWebDriver driver;

	public PageObject(RemoteWebDriver driver){
		this.driver = driver;
	}

	// Handlers for page elements
	public void openDefaultUrl(){
		openUrl(URL);
	}

	public void openUrl(final String url){
		driver.get(URL);
	}

	public void clickOnElement(final By elementLocator){
		driver.findElement(elementLocator).click();
	}

	public String getTextFromElement(final By elementLocator){
		return driver.findElement(elementLocator).getText();
	}

	public void enterShop(){
		clickOnElement(PageObject.ENTER_LINK);
	}

	public void signInDefaultUser() {
		clickOnElement(PageObject.SIGN_IN_LINK);
		clickOnElement(PageObject.SUBMIT);
	}

	public void navigateToRattlelessRattlesnake() {
		clickOnElement(PageObject.REPTILES_LINK);
		clickOnElement(PageObject.RATTLESNAKES_LINK);
		clickOnElement(PageObject.RATTLELESS_RATTLESNAKES_LINK);
	}

	public void signOut() {
		clickOnElement(PageObject.SIGN_OUT_LINK);
	}

	public void closeDriver() {
		driver.close();
	}
}

