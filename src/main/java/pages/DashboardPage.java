package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

    //private WebDriver driver;
    private WebElement quickLaunch;
    private By assignLeave = By.linkText("Assign Leave");
            //By.xpath("//*[@href='/index.php/leave/assignLeave']");  //This xpath did not work: Element not found error

    DashboardPage(WebDriver driver) {
        super(driver);
    }

    public AssignLeavePage clickAssignLeaveButton(){
        quickLaunch = driver.findElement(By.id("dashboard-quick-launch-panel-menu_holder"));
        quickLaunch.findElement(assignLeave).click();
        return new AssignLeavePage(driver);
    }
}
