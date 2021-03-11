import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;

// This is for negative testing (exception testing)
public class searchCustomerTest {


  // Trying to set the txtPhoto label to null but I think
  // we may need to make the byte[] userimage null or the
  // String path null to test it. Not sure what I am doing to be honest.
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
    Assert.assertTrue(searchCustomer.button1IsIOExceptionThrown);
    System.out.println("Button 1 IO exception was caught");

  }



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
    Assert.assertTrue(searchCustomer.button2IsSQLThrown);
    System.out.println("Button2 SQLException test should pass.");
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
    Assert.assertTrue(searchCustomer.button4IsSQLThrown);
    System.out.println("Button4 SQLException test should pass.");
  }

}
