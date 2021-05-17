import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashboardPage;

import static org.testng.Assert.*;

public class LogInTests extends BaseTests {

    @Test
    public void invalidPasswordTest(){
        loginPage.setUsername("TestUser");
        loginPage.setPassword("123123");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getSpanMessage(), "Invalid credentials", "Span message does not match the expected");
    }

    @Test
    public void emptyPasswordTest(){
        loginPage.setUsername("Admin");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getSpanMessage(), "Invalid credentials", "Password cannot be empty");
    }

    @Test
    public void correctLoginTest(){
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        DashboardPage dashboardPage = loginPage.clickLoginButton();

        assertEquals(dashboardPage.getContentHeader(),"Dashboard", "Content header does not match thee expected" );
        ;

    }

}
