package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By contentHead = By.cssSelector("#content .head");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getContentHeader(){
        return driver.findElement(contentHead).getText();
    }
}
