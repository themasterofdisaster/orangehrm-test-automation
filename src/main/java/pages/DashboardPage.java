package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

    //private WebDriver driver;
    private WebElement quickLaunch = driver.findElement(By.id("dashboard-quick-launch-panel-menu_holder"));
    private By assignLeave = By.xpath("//*[@href='/index.php/leave/assignLeave']");

    DashboardPage(WebDriver driver) {
        super(driver);
    }

    private AssignLeavePage clickAssignLeaveButton(){
        quickLaunch.findElement(assignLeave).click();
        return new AssignLeavePage(driver);
    }
}
