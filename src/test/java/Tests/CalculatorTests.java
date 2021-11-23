package Tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.calcPage;

public class CalculatorTests extends baseTests{
    calcPage myCalcPage;
    public CalculatorTests(){
        openBrowser();
        driver=new ChromeDriver();
        myCalcPage=new calcPage(driver);
    }
    @Test
    public void powersOfTwo(){
        driver.get(URL);
        myCalcPage.clickOpenHistory();

        myCalcPage.clickButtonClear();
        myCalcPage.clickTwoPowerX("one");
        myCalcPage.clickButtonCalcResult();
        Assert.assertEquals(myCalcPage.getNumberFromResult(), "2", "ERROR DIDN'T GET 2!");

        myCalcPage.clickButtonClear();
        myCalcPage.clickTwoPowerX("two");
        myCalcPage.clickButtonCalcResult();
        Assert.assertEquals(myCalcPage.getNumberFromResult(),"4","ERROR DIDN'T GET 4!");

        myCalcPage.clickButtonClear();
        myCalcPage.clickTwoPowerX("three");
        myCalcPage.clickButtonCalcResult();
        Assert.assertEquals(myCalcPage.getNumberFromResult(),"8","ERROR DIDN'T GET 8!");
        myCalcPage.printHistoryOfCalculations();
    }

}
