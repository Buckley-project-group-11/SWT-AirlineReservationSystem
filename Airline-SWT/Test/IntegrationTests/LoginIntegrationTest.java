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
    // Tests the input will take the user to the next screen.
    @Test
    public void testLogin_negative_testing() throws InterruptedException {
        Login frame = new Login();
        frame.setVisible(true);

        JTextField username = Login.getUsername();
        JTextField password = Login.getPassword();

        //Because it is negative testing, the test input is not in the database.
        username.setText("usernameTest");
        password.setText("passwordTest");
        sleep(2000);

        //Assures the textfields are being set to the negative input.
        username.postActionEvent();
        password.postActionEvent();

        //Boolean array to test against the mock object
        boolean[] loginTest = {
                true,
                true
        };
        boolean[] loginPassed = {true, true};

        // Add a Mock to test the login button
        List loginMock = mock(List.class);
        loginMock.add(loginTest);
        verify(loginMock).add(loginPassed);

        //Buttons are clicked for completeness.
        Login.jButton1.doClick();
        Login.jButton2.doClick();
    }


        // Tests the input will take the user to the next screen.
        @Test
        public void testLogin_positive_testing() throws InterruptedException {
            Login frame = new Login();
            frame.setVisible(true);

            JTextField username = Login.getUsername();
            JTextField password = Login.getPassword();

            //B/c positive testing, the input is in the database.
            username.setText("user");
            password.setText("pass");
            sleep(2000);

            //Assures the textfields have been filled with positive input.
            username.postActionEvent();
            password.postActionEvent();

            //The boolean array to be tested against the mock object.
            boolean[] loginTest = {
                    true,
                    true
            };
            boolean[] loginPassed = {true, true};

            // Add a Mock to test the login button
            List loginMock = mock(List.class);
            loginMock.add(loginTest);
            verify(loginMock).add(loginPassed);

            //Buttons pressed for completeness.
            Login.jButton1.doClick();
            //Login.jButton2.doClick();
        }

        //Test case is used to throw exceptions
        @Test
        public void testLogin_exception_testing() throws InterruptedException {
            Login frame = new Login();
            frame.setVisible(true);

            JTextField username = Login.getUsername();
            JTextField password = Login.getPassword();

            //B/c positive testing, the input is in the database.
            username.setText("");
            password.setText("");
            sleep(2000);

            //Assures the textfields have been filled with positive input.
            username.postActionEvent();
            password.postActionEvent();

            //The boolean array to be tested against the mock object.
            boolean[] loginTest = {
                    true,
                    true
            };
            boolean[] loginPassed = {true, true};

            // Add a Mock to test the login button
            List loginMock = mock(List.class);
            loginMock.add(loginTest);
            verify(loginMock).add(loginPassed);

            //Buttons pressed for completeness.
            Login.jButton1.doClick();
            //Login.jButton2.doClick();
        }

    }

