package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class AssignLeavePage extends BasePage{

    private By employeeNameFieldLocator = By.id("assignleave_txtEmployee_empName");
    private By employeeAutoCompleteResultsLocator = By.className("ac_results");
    private By leaveTypeDropdownLocator = By.id("assignleave_txtLeaveType");
    private Select leaveTypeDropdown = new Select(driver.findElement(leaveTypeDropdownLocator));
    private By fromDateLocator = By.id("assignleave_txtFromDate");
    private By toDateLocator = By.id("assignleave_txtToDate");


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

    public void typeFromDate(String date){
        driver.findElement(fromDateLocator).sendKeys(date);

    }

    public void typeToDate(String date){
        driver.findElement(toDateLocator).sendKeys(date);
    }

}
