/**
 * 
 */
package initializePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.calcPage;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 * 
 */

public class PageFactoryInitializer
{
	public calcPage calcPage(WebDriver driver)
	{

		return PageFactory.initElements(driver, calcPage.class);
	}

}
