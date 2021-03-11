import static java.lang.Thread.sleep;

import javax.swing.JTextField;
import org.junit.Assert;
import org.junit.Test;

public class userCreationTest {

  // Testing SQLException for Button 1 (Add)
  @Test
  public void testButton1SQLException() throws InterruptedException {
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
    // In userCreation SQLException catch, button1IsSQLThrown set to true
    // This was work around since I wasn't able to get
    // jButton1ActionPerformed to throw an exception for some reason
    // If invalid input, and SQL not thrown, test fails
    // If invalid input, and SQL thrown, test passes
    Assert.assertTrue(creation.button1IsSQLThrown);
    System.out.println("Button1 SQLException test should pass.");
  }

  @Test
  public void testButton2() {
    // Create instance of the searchCustomer class
    userCreation cancel = new userCreation();
    cancel.setVisible(true);
    cancel.jButton2.doClick();
    Boolean isHidden =cancel.getVisibility();
    System.out.println("Button2 test should pass.");
    Assert.assertTrue(isHidden);

  }
}
