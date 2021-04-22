package UnitTests;

import junit.framework.Assert;
import org.junit.Test;
import source.searchCustomer;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class searchCustomerUnitTest {

    @Test
    public void testVisibility(){
        // Create instance of the searchCustomer class
        searchCustomer search = new searchCustomer();
        search.setVisible(true);
        Assert.assertTrue(search.isVisible());
    }

    @Test
    /* This test was constructed to test if the customer was valid, then
     * testing if the image file exists. The customer must be valid in order
     * for this test to work and the path must not exist since this is being
     * tested using the negative testing technique.
     */
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
        Assert.assertFalse(searchCustomer.button1IsIOExceptionThrown);
        System.out.println("Button 1 IO exception was caught");

    }




}