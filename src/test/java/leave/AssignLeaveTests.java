package leave;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AssignLeavePage;
import pages.DashboardPage;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

public class AssignLeaveTests extends BaseTests {

    private SoftAssert softAssert = new SoftAssert();
    private List<String> expectedAutocompletedEmployeeNames = List.of("Lisa Andrews", "Sania Shaheen", "Sara Tencrady"); //sa
    //private List<String> expectedAutocompletedEmployeeNames = List.of("Chenzira Chuki", "Ehioze Ebo"); //z
    //private List<String> expectedAutocompletedEmployeeNames = List.of("Jordan Mathews", "David Morris", "Ananya Dash"); //da
    //private List<String> expectedAutocompletedEmployeeNames = List.of("Rebecca Harmony", "Ehioze Ebo"); //eb

    @Test
    public void navigateToAssignLeaveTest(){
//        Calendar fromDate = Calendar.getInstance();
//        fromDate.add(Calendar.MONTH, 2);
        LocalDate fromDate = LocalDate.now().plusMonths(2);
        LocalDate toDate = fromDate.plusDays(7);


        DashboardPage dashboardPage = loginPage.login();
        AssignLeavePage assignLeavePage = dashboardPage.clickAssignLeaveButton();
        softAssert.assertEquals(assignLeavePage.getContentHeader(), "Assign Leave", "Content header does not match the expected");
        //softAssert.assertEquals(assignLeavePage.getAssignedLeaveBalance(), 0.00);

        assignLeavePage.typeEmployeeName("Sa");

        List<String> autocompletedEmployeeNames = assignLeavePage.getEmployeeAutoCompletedNames();
        softAssert.assertEquals(autocompletedEmployeeNames, expectedAutocompletedEmployeeNames, "Listed names do not match");

        assignLeavePage.typeEmployeeName("nia Shaheen");
        assignLeavePage.selectLeaveType("CAN - Vacation");
        assignLeavePage.setFromDate(fromDate);
        assignLeavePage.setToDate(toDate);
        assignLeavePage.setComment("Paid leave");
        assignLeavePage.clickAssignButton();
        assignLeavePage.modal_clickConfirmCancelButton();

        //softAssert.assertEquals(assignLeavePage.getAssignedLeaveBalance(), 0);

        softAssert.assertAll();

    }

}
