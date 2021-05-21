package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class AssignLeavePage extends BasePage{

    private By employeeNameFieldLocator = By.id("assignleave_txtEmployee_empName");
    private By employeeAutoCompleteResultsLocator = By.className("ac_results");
    private By leaveTypeDropdownLocator = By.id("assignleave_txtLeaveType");
    private Select leaveTypeDropdown = new Select(driver.findElement(leaveTypeDropdownLocator));
    private By fromDateLocator = By.id("assignleave_txtFromDate");
    private By toDateLocator = By.id("assignleave_txtToDate");
    private By commentTextArea = By.id("assignleave_txtComment");
    private By assignButton = By.id("assignBtn");
    private By leaveBalanceModal = By.id("leaveBalanceConfirm");
    private By modal_confirmCancelButton = By.id("confirmCancelButton");
    private By assignLeaveBalanceLabel = By.id("assignleave_leaveBalance");


    public AssignLeavePage(WebDriver driver){
        super(driver);
    }

    public void typeEmployeeName(String employeeName){
        driver.findElement(employeeNameFieldLocator).sendKeys(employeeName);

    }

    public List<String> getEmployeeAutoCompletedNames(){

        WebElement employeeAutocompleteResultsWebElement = driver.findElement(employeeAutoCompleteResultsLocator);
        List<WebElement> employeeAutocompletedNames = employeeAutocompleteResultsWebElement.findElements(By.tagName("li"));

        return employeeAutocompletedNames.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void selectLeaveType(String leaveType){
        leaveTypeDropdown.selectByVisibleText(leaveType);
    }

    public void setFromDate(LocalDate fromDate){
        driver.findElement(fromDateLocator).clear();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        driver.findElement(fromDateLocator).sendKeys(dtf.format(fromDate) + Keys.ENTER);
    }

    public void setToDate(LocalDate fromDate){
        driver.findElement(toDateLocator).clear();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        driver.findElement(toDateLocator).sendKeys(dtf.format(fromDate) + Keys.ENTER);
    }

    public void setComment(String comment){
        driver.findElement(commentTextArea).sendKeys(comment);
    }

    public void clickAssignButton(){
        driver.findElement(assignButton).click();
    }

    public void modal_clickConfirmCancelButton(){
        driver.findElement(modal_confirmCancelButton).click(); //element not visible? 
    }

//    public double getAssignedLeaveBalance(){
//        return Double.parseDouble(driver.findElement(assignLeaveBalanceLabel).getText());
//    }

}
