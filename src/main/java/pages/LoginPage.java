package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("txtUsername");
    private By passwordField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By spanMessage = By.id("spanMessage");

    private String userName = "Admin";
    private String password = "admin123";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public String getSpanMessage(){
        return driver.findElement(spanMessage).getText();
    }

    public DashboardPage login(){
        typeUsername(userName);
        typePassword(password);
        return clickLoginButton();
    }
}
