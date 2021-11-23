package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seleniumActions extends ExplicitWaiting {
    public static void clickButton(By currentBy, String textToBeVisible) {
        WebElement currentWebElement = driver.findElement(currentBy);
        ExplicitWaiting.explicitWaitElementToBeClickable(currentWebElement, 10);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(currentWebElement, 10, textToBeVisible);
        System.out.println("CLICKING WEB ELEMENT(USING BY)" + currentWebElement.getText());
        currentWebElement.click();
    }

    public static void clickButton(WebElement currentWebElement, String textToBeVisible,
                                   WebDriver driver) {
        ExplicitWaiting.driver = driver;
        ExplicitWaiting.explicitWaitElementToBeClickable(currentWebElement, 10);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(currentWebElement, 10, textToBeVisible);
        System.out.println("CLICKING WEB ELEMENT" + currentWebElement.getText());
        currentWebElement.click();
    }

    public static void clickAndSyncWithNextElement(By byElementToclickint, String textOnClicked, By expectedElement, int maxDelayNumber) {
        int delayNumber;
        for (delayNumber = 1; delayNumber <= maxDelayNumber; ++delayNumber) {
            try {
                seleniumActions.clickButton(byElementToclickint, textOnClicked);
                ExplicitWaiting.explicitWaitElementToBeClickable(expectedElement, 1,driver);
            } catch (Exception e) {
                System.out.println("Still synching with next GUI element");
            }
        }
    }
}
