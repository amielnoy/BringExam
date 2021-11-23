package pageObjects;

import initializePageObjects.PageFactoryInitializer;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ExplicitWaiting;
import utils.seleniumActions;

import java.util.List;


public class calcPage extends PageFactoryInitializer {
    WebDriver driver;
    public static Actions ac;
    final static Logger logger = Logger.getLogger(calcPage.class);


    protected WebElement buttonTwoPowerX;
    @FindBy(id = "BtnLog1")
    protected WebElement buttonInputHelper;

    protected WebElement buttonOne;

    protected WebElement buttonTwo;

    protected WebElement buttonThree;

    protected WebElement editInput;

    protected WebElement buttonLog;

    protected WebElement buttonCalc;

    protected WebElement clearButton;

    protected WebElement openHistoryButton;

    protected WebElement historyOfCalcsEdit;

    public calcPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    /* To Perform a WebAction of Mouse Over */
    public void mousehover(WebElement element) {
        ac = new Actions(getWebDriver());
        ac.moveToElement(element).build().perform();
    }


    public void clickTwoPowerX(String numberToClick) {
        Allure.step("clicking 2 power X");

        switch (numberToClick) {
            case "one":
                buttonOne = driver.findElement(By.id("Btn1"));
                buttonOne.click();
                break;
            case "two":
                buttonTwo = driver.findElement(By.id("Btn2"));
                buttonTwo.click();
                break;
            case "three":
                buttonThree = driver.findElement(By.id("Btn3"));
                buttonThree.click();
                break;
        }
        buttonLog=driver.findElement(By.id("BtnLog10"));
        mousehover(buttonLog);
        ExplicitWaiting.waitInSeconds(2);
        clickButtonPowerTwoOfX();
    }

    public void clickButtonPowerTwoOfX() {
        buttonTwoPowerX = driver.findElement(By.id("Button2X"));
        buttonTwoPowerX.click();
    }

    public void clickButtonCalcResult() {
        buttonCalc = driver.findElement(By.id("BtnCalc"));
        buttonCalc.click();
        ExplicitWaiting.waitInSeconds(2);
    }

    public void clickOpenHistory(){
        openHistoryButton=driver.findElement(By.id("hist"));
        openHistoryButton.click();
    }

    public void clickButtonClear(){
        clearButton=driver.findElement(By.id("BtnClear"));
        clearButton.click();
    }

    public String getResultFromHistory() {
        editInput =driver.findElement(By.xpath("//*[@id=\"histframe\"]/ul"));
        List<WebElement> lines = editInput.findElements(By.tagName("li"));
        return lines.get(0).getText();
    }

    public String getNumberFromResult(){
        return getResultFromHistory().split("\n")[0].substring(2);
    }

    public void  printHistoryOfCalculations(){
        historyOfCalcsEdit= driver.findElement(By.xpath("//*[@id=\"histframe\"]/ul"));
        List<WebElement> lines = historyOfCalcsEdit.findElements(By.tagName("li"));

        System.out.println("Printing history of calculations:");
        for (int i = 0; i < lines.size(); i++)
        {
            System.out.println(lines.get(i).getText());
        }
    }
}
