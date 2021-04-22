package UnitTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.addCustomer;
import source.userCreation;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class userCreationUnitTest extends TestCase {

    Connection con;
    PreparedStatement pst;
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

    @Test
    public void creat_user_test(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            pst = con.prepareStatement("DELETE from user where id = ?");
            pst.setString(1, "UO001");
            pst.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        userCreation useTest = new userCreation();
        useTest.autoID();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            pst = con.prepareStatement("insert into user(id,firstname,lastname, username, password)values(?,?,?,?,?)");

            pst.setString(1, "UO001");
            pst.setString(2, "Bill");
            pst.setString(3, "Phill");
            pst.setString(4, "user");
            pst.setString(5, "pass");
            pst.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

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

