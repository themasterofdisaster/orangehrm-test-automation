package leave;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AssignLeavePage;
import pages.DashboardPage;

import java.util.Calendar;
import java.util.List;

import static org.testng.Assert.*;

public class AssignLeaveTests extends BaseTests {

    private List<String> expectedAutocompletedEmployeeNames = List.of("John Smith", "Jordan Mathews", "Joe Root");

    @Test
    public void navigateToAssignLeaveTest(){
        Calendar fromDate = Calendar.getInstance();
        fromDate.add(Calendar.DAY_OF_MONTH, 30);


        DashboardPage dashboardPage = loginPage.login();
        AssignLeavePage assignLeavePage = dashboardPage.clickAssignLeaveButton();
        assertEquals(assignLeavePage.getContentHeader(), "Assign Leave", "Content header does not match the expected");

        assignLeavePage.typeEmployeeName("Jo");

        List<String> autocompletedEmployeeNames = assignLeavePage.getEmployeeAutoCompletedNames();
        assertEquals(autocompletedEmployeeNames, expectedAutocompletedEmployeeNames, "Listed names do not match");

        assignLeavePage.typeEmployeeName("e Root");
        assignLeavePage.selectLeaveType("CAN - Vacation");
        assignLeavePage.typeFromDate(fromDate.toString());

    }

}
