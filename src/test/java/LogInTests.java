import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LogInTests extends BaseTests {

    @Test
    public void invalidPasswordTest(){
        loginPage.setUsername("TestUser");
        loginPage.setPassword("123123");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getSpanMessage(), "Invalid credentials", "Span message does not match the expected");
    }

}
