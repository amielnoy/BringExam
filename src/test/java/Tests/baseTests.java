package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class baseTests extends base {
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}