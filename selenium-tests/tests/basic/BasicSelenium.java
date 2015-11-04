package basic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This class presents a pure usage of Selenium WebDriver framework.
 * The Page Object Pattern has not been applied here. 
 * 
 * In order to execute the test case start a JPetStore app and provide its address if it is not on local host.
 * 
 * @author Mirek Rakowski <https://github.com/mirek-rakowski>
 * @see https://github.com/mirek-rakowski/TestAutomation
 * @see Wiki on <https://github.com/mirek-rakowski/TestAutomation/wiki> for more info.
 */
public class BasicSelenium {

	RemoteWebDriver driver;
	
    @BeforeClass
    public void setUp()
    {
        driver = new FirefoxDriver();
    }

    @Test public void validateRattlesnakeGrid() throws Exception {

    	// TODO: Here you have to provide a correct URL for the JPetStore app.
    	 driver.get("http://localhost:8080/jpetstore/");
    	
    	 driver.findElement(By.linkText("Enter the Store")).click();
    	 driver.findElement(By.linkText("Sign In")).click();
    	 driver.findElement(By.name("submit")).click();
    	 driver.findElement(By.xpath("//div[@id='QuickLinks']/a[3]/img")).click();
    	 driver.findElement(By.linkText("RP-SN-01")).click();
    	 driver.findElement(By.linkText("EST-12")).click();
    	 
    	assertEquals(driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[2]/td/b")).getText(), "EST-12");
    	assertEquals(driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[3]/td/b/font")).getText(), "Rattleless Rattlesnake");
    	assertEquals(driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[4]/td")).getText(), "Rattlesnake");
    	assertEquals(driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[5]/td")).getText(), "10000 in stock.");
    	assertEquals(driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[6]/td")).getText(), "$18,50");

    	driver.findElement(By.linkText("Sign Out")).click();
   	 
    	assertEquals(driver.findElement(By.xpath("//div[@id='MenuContent']/a[2]")).getText(), "Sign In");
    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}

