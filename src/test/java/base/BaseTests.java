package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
