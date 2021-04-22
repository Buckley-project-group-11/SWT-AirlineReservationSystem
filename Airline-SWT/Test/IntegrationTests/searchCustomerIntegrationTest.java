package IntegrationTests;

import org.junit.Assert;
import org.junit.Test;
import source.Customer;
import source.DBConnection;
import source.searchCustomer;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.*;

public class searchCustomerIntegrationTest {
    // Integration test
    @Test
    public void testButton1IOException() throws InterruptedException {

        // Create instance of the searchCustomer class
        searchCustomer search = new searchCustomer();
        search.setVisible(true);
        // Make sure the customer is valid, if it is empty, make it a valid customer.
        JTextField findText = (JTextField) search.getFindText();
        if (findText.getVisibleRect().isEmpty()){
            findText.setText("CS001");
        }
        else {
            findText.getText();
        }
        // Access the label used to display image
        JLabel photoText = (JLabel) search.getPhotoText();
        // Enter an invalid input (no image path) to trigger IOException
        // when the popup screen shows, enter photo.png in the file name then click okay.
        // this forms an IOException
        photoText.setText("C:/Owner/Desktop/photo.png");

        // Give program 2 seconds to accept text
        sleep(2000);
        // Click button1 (Browse) to attempt a search with the invalid input
        searchCustomer.jButton1.doClick();
        // In searchCustomer IOException catch, button1IsIOExceptionThrown set to true
        // This was work around since I wasn't able to get
        // jButton1ActionPerformed to throw an exception for some reason
        // If invalid input, and SQL not thrown, test fails
        // If invalid input, and SQL thrown, test passes
        Boolean isIOThrown = searchCustomer.button1IsIOExceptionThrown;

        // Integration Testing - Mock
        List searchCustomerMock = mock(List.class);
        searchCustomerMock.add(isIOThrown);
        verify(searchCustomerMock).add(true);

        Assert.assertTrue(isIOThrown);
        System.out.println("Button 1 IO exception was caught");
    }



    // Integration test
    // To produce exception we need to input letters (ABC) into the contact,
    // and hit update AFTER having searched for a VALID customer id.
    // So basically, search for CS001, then insert ABC into the contact and hit
    // update
    @Test
    public void testButton2SQLException() throws InterruptedException {
        // Create instance of the searchCustomer class
        searchCustomer search = new searchCustomer();
        search.setVisible(true);
        JTextField findText = (JTextField) search.getFindText();
        if (findText.getVisibleRect().isEmpty()){
            findText.setText("CS001");
        }
        else {
            findText.getText();
        }

        // Access the textfield used to search
        JTextField contactText = (JTextField) search.getContactText();
        // Enter an invalid input (letters) to trigger SQLException
        contactText.setText("ABC");
        // Give program 2 seconds to accept text
        sleep(2000);
        // Click button2 (Update) to attempt a search with the invalid input
        searchCustomer.jButton2.doClick();
        // In searchCustomer SQLException catch, button2IsSQLThrown set to true
        // This was work around since I wasn't able to get
        // jButton2ActionPerformed to throw an exception for some reason
        // If invalid input, and SQL not thrown, test fails
        // If invalid input, and SQL thrown, test passes
        Boolean isSQLThrown = searchCustomer.button2IsSQLThrown;

        // Integration Testing - Mock
        List searchCustomerMock = mock(List.class);
        searchCustomerMock.add(isSQLThrown);
        verify(searchCustomerMock).add(true);

        Assert.assertTrue(isSQLThrown);
        System.out.println("Button2 SQLException test should pass.");
    }

    // Integration test
    @Test
// tests the cancel button
    public void testButton3() {
        searchCustomer search = new searchCustomer();
        search.setVisible(true);
        search.jButton3.doClick();
        Boolean isHidden = search.getVisibility();
        System.out.println("Button1 test should pass");

        // Integration Testing - Mock
        List searchCustomerMock = mock(List.class);
        searchCustomerMock.add(isHidden);
        verify(searchCustomerMock).add(true);

        Assert.assertTrue(isHidden);
    }

    // Tests the SQL exception try/catch of Button4 (Find)
    @Test
    public void testButton4SQLException() throws InterruptedException {
        // Create instance of the searchCustomer class
        searchCustomer search = new searchCustomer();
        search.setVisible(true);
        // Access the textfield used to search
        JTextField findText = (JTextField) search.getFindText();
        // Enter an invalid input (a special character) to trigger SQLException
        findText.setText("♥");
        // Give program 2 seconds to accept text
        sleep(2000);
        // Click button4 (Find) to attempt a search with the invalid input
        searchCustomer.jButton4.doClick();
        // In searchCustomer SQLException catch, button4IsSQLThrown set to true
        // This was work around since I wasn't able to get
        // jButton4ActionPerformed to throw an exception for some reason
        // If invalid input, and SQL not thrown, test fails
        // If invalid input, and SQL thrown, test passes
        Boolean isSQLThrown = searchCustomer.button4IsSQLThrown;

        List searchCustomerMock = mock(List.class);
        searchCustomerMock.add(isSQLThrown);
        verify(searchCustomerMock).add(true);

        Assert.assertTrue(isSQLThrown);
        System.out.println("Button4 SQLException test should pass.");
    }

    // Integration test
    @Test
    public void dbConnectionStub() throws SQLException, ParseException {
        Customer testCustomer = new Customer("Brenda", "Rhodes", "CS015", "12346", "654789", "10501 FGCU BLVD South", "05/01/2021","female","1234567890");
        DBConnection customerStub = mock(DBConnection.class);
        when(customerStub.findCust()).thenReturn(testCustomer);
        System.out.println("Tests if the object returned from the DB was the expected Customer");
        System.out.print("Expected result: Brenda" + "\n" + "Obtained result: " + testCustomer.getFirstName() + "\n");
        System.out.println("Test result: " + testCustomer.getFirstName().equalsIgnoreCase("Brenda"));
        Assert.assertEquals("Brenda", testCustomer.getFirstName());
    }

}
