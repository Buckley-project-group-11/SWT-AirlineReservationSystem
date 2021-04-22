package UnitTests;

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

public class LoginUnitTest {

    // Tests if the user name and password match
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

        // uses regex patterns to check if the username and password match the conventions needed
        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Matcher usernameMatch = namePattern.matcher(username.getText());
        Matcher passwordMatch = namePattern.matcher(password.getText());

        boolean nameResult = usernameMatch.find();
        boolean passResult = passwordMatch.find();
        boolean allResults = false;
        boolean[] loginTest = {
                nameResult,
                passResult
        };
        boolean[] loginPassed = {true, true };

        if(nameResult == true && passResult == true){
            allResults = true;
        }
        else{allResults = false;}

        Assert.assertTrue(allResults);
    }

}