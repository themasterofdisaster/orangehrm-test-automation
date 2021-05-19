import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashboardPage;

import static org.testng.Assert.*;

public class LogInTests extends BaseTests {

    @Test
    public void invalidPasswordTest(){
        loginPage.typeUsername("TestUser");
        loginPage.typePassword("123123");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getSpanMessage(), "Invalid credentials", "Span message does not match the expected");
    }

    @Test
    public void emptyPasswordTest(){
        loginPage.typeUsername("Admin");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getSpanMessage(), "Invalid credentials", "Password cannot be empty");
    }

    @Test
    public void successfulLoginTest(){
        DashboardPage dashboardPage = loginPage.login();

        assertEquals(dashboardPage.getContentHeader(),"Dashboard", "Content header does not match the expected" );

    }

}
