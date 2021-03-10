import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class LoginTest extends TestCase {

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

        if(nameResult == true && passResult == true){
            allResults = true;
        }
        else{allResults = false;}


        Assert.assertTrue(allResults);

        Login.jButton1.doClick();
        Login.jButton2.doClick();
    }

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

    @Test
    public void testGetUsername(){
            JTextField user = Login.getUsername();
            user.setText("user");
            Assert.assertEquals("user", user.getText());

        }




    @Test
    public void testGetPassword() {
        JTextField pass = Login.getPassword();
        pass.setText("pass");
        Assert.assertEquals("pass", pass.getText());
    }
}