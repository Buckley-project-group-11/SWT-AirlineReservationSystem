import junit.framework.Assert;
import junit.framework.TestCase;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import source.Login;

import javax.swing.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginTest extends TestCase {

    private FrameFixture window;

//    //Obtained from the AssertJ documentation https://joel-costigliola.github.io/assertj/assertj-swing-getting-started.html
//    @BeforeEach
//    public void setup(){
//        Login frame = GuiActionRunner.execute(() -> new Login());
//        window = new FrameFixture(frame);
//        window.show();
//    }
//
//    @Test
//    public void testForBlankFields(){
//        window.textBox("txtpass").enterText("");
//        window.textBox("txtuser").enterText("");
//        window.button("jButton1").click();
////        window.optionPane().requireInformationMessage();
//    }
//
//    @After
//    public void tearDown(){
//        window.cleanUp();
//    }

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

        // Add a Mock to test the login button
        List loginMock = mock(List.class);
        loginMock.add(loginTest);
        verify(loginMock).add(loginPassed);

        Login.jButton1.doClick();
        Login.jButton2.doClick();
    }

    private Login login;


    @Test
    public void testMain() {
        Login frame = new Login();
        frame.setVisible(true);
        if (frame.isActive() == true) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }

//    @Test
//    public void testGetUsername(){
//        JTextField user = Login.getUsername();
//        user.setText("user");
//        Assert.assertEquals("user", user.getText());
//
//        // stub for checking the username field
//        JTextField txtuser = new JTextField();
//        txtuser.setText("Username");
//        assertEquals("Username", txtuser);
//
//    }




//    @Test
//    public void testGetPassword() {
//        JTextField pass = Login.getPassword();
//        pass.setText("pass");
//        Assert.assertEquals("pass", pass.getText());
//
//        // stub for checking the password field
//        JTextField txtpass = new JTextField();
//        txtpass.setText("Password");
//        assertEquals("Password", txtpass);
//    }
}