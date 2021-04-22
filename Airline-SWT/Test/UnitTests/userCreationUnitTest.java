package UnitTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.userCreation;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class userCreationUnitTest extends TestCase {
    //Unit Testing the functional requirement FUN-2 using negative testing.
    @Test
    public void test_FUN2_exception_handling() throws InterruptedException {
        // Create instance of the userCreation class
        userCreation creation = new userCreation();
        creation.setVisible(true);
        // Access the textfield used to fill the first name
        // It doesn't have to be the first name, I am just using it for this test
        JTextField fNameText = (JTextField) creation.getFNameText();
        // Enter an invalid input (a special character) to trigger SQLException
        fNameText.setText("♥");
        // Give program 2 seconds to accept text
        sleep(2000);
        // Click button1 (Add) to attempt to add a user with the invalid input
        creation.jButton1.doClick();
        /* In userCreation SQLException catch, button1IsSQLThrown set to true
        This was work around since I wasn't able to get
        jButton1ActionPerformed to throw an exception for some reason
        If invalid input, and SQL not thrown, test fails
        If invalid input, and SQL thrown, test passes
         */
        Assert.assertTrue(creation.button1IsSQLThrown);
        System.out.println("Button1 SQLException test should pass.");
    }

    //Test the GUI component's functionality associated with requirement FUN-2
    @Test
    public void test_FUN2_GUI_testing(){
        // Create instance of the searchCustomer class
        userCreation cancel = new userCreation();
        cancel.setVisible(true);
        cancel.jButton2.doClick();
        Boolean isHidden =cancel.getVisibility();
        System.out.println("Button2 test should pass.");
        Assert.assertTrue(isHidden);
    }

}

