package SystemTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.Login;

public class LoginGUITest extends TestCase {

    @Test
    public void test_jbutton1(){
        Login login_test = new Login();
        login_test.setVisible(true);
        Login.jButton1.doClick();
        Assert.assertTrue(login_test.isVisible());
    }

    @Test
    public void test_jbutton2(){
        Login login_test = new Login();
        login_test.setVisible(true);
        Login.jButton2.doClick();
        Assert.assertTrue(login_test.isVisible());
    }

}