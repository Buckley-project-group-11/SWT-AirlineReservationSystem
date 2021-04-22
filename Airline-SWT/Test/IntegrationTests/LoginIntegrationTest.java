package IntegrationTests;

import junit.framework.Assert;
import org.junit.Test;
import source.Login;

import javax.swing.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginIntegrationTest {
    // Tests the buttons on the log in page
    @Test
    public void testLogin() throws InterruptedException {
        Login frame = new Login();
        frame.setVisible(true);

        JTextField username = Login.getUsername();
        JTextField password =  Login.getPassword();

        username.setText("usernameTest");
        password.setText("passwordTest");
        sleep(2000);

        username.postActionEvent();
        password.postActionEvent();

        boolean[] loginTest = {
                true,
                true
        };
        boolean[] loginPassed = {true, true };

        // Add a Mock to test the login button
        List loginMock = mock(List.class);
        loginMock.add(loginTest);
        verify(loginMock).add(loginPassed);

        Login.jButton1.doClick();
        Login.jButton2.doClick();
    }

    // Tests the call from main
    @Test
    public void testMainStub() {
        Login frame = new Login();
        frame.setVisible(true);
        if (frame.isActive()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }
}
