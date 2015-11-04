package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.PageObject;

/**
 * This class is an example that Page Objects can be resused for more tests for Selenium WebDriver framework.
 * 
 * In order to execute the test case start a JPetStore app and provide its address if it is not on local host.
 * 
 * @author Mirek Rakowski <https://github.com/mirek-rakowski>
 * @see https://github.com/mirek-rakowski/TestAutomation
 * @see Wiki on <https://github.com/mirek-rakowski/TestAutomation/wiki> for more info.
 */
public class AuthenticationTests {

	PageObject po;

	@BeforeClass
	public void setUp()
	{
		po = new PageObject(new FirefoxDriver());
	}

	/**
	 * This tests checks the basic authentication
	 */
	@Test public void ifSignInAndSignOutSuccessfully(){
		po.openDefaultUrl();
		po.enterShop();
		po.signInDefaultUser();
		
		assertEquals(po.getTextFromElement(PageObject.HEADER_LABEL), "Sign Out");

		po.signOut();

		assertEquals(po.getTextFromElement(PageObject.HEADER_LABEL), "Sign In");
	}

	@AfterClass
	public void tearDown()
	{
		po.closeDriver();
	}
}

