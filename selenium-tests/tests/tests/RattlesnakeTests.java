package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.PageObject;

/**
 * This class presents flow of Page Object patters for Selenium WebDriver framework.
 * 
 * In order to execute the test case start a JPetStore app and provide its address if it is not on local host.
 * 
 * @author Mirek Rakowski <https://github.com/mirek-rakowski>
 * @see https://github.com/mirek-rakowski/TestAutomation
 * @see Wiki on <https://github.com/mirek-rakowski/TestAutomation/wiki> for more info.
 */

public class RattlesnakeTests {

	PageObject po;

	@BeforeClass
	public void setUp()
	{
		po = new PageObject(new FirefoxDriver());
	}

	/**
	 * Test that verifies if all Rattleless Rattlesnake details in the grid are valid.
	 */
	@Test public void validateRattlesnakeGrid() {
		po.openDefaultUrl();
		po.enterShop();
		po.signInDefaultUser();
		po.navigateToRattlelessRattlesnake();

		assertEquals(po.getTextFromElement(PageObject.CODE_CELL), "EST-12");
		assertEquals(po.getTextFromElement(PageObject.SPECIES_CELL), "Rattleless Rattlesnake");
		assertEquals(po.getTextFromElement(PageObject.GROUP_CELL), "Rattlesnake");
		assertEquals(po.getTextFromElement(PageObject.QUANTITY_CELL), "10000 in stock.");
		assertEquals(po.getTextFromElement(PageObject.PRICE_CELL), "$18,50");

		po.signOut();

		assertEquals(po.getTextFromElement(PageObject.HEADER_LABEL), "Sign In");
	}

	@AfterClass
	public void tearDown()
	{
		po.closeDriver();
	}
}

