import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import org.junit.Assert;
import org.junit.Test;

public class ticketTest {

  // Tests SQLException for Button 1 (Book)
  @Test
  public void testButton1SQLException() throws InterruptedException {
    // Create instance of the ticket class
    ticket myTicket = new ticket();
    myTicket.setVisible(true);
    // Access the textfield used to fill in the price
    JTextField priceText = (JTextField) myTicket.getPriceText();
    // Enter an invalid input (ABC) to trigger SQLException
    priceText.setText("ABC");
    // Give program 2 seconds to accept text
    sleep(2000);
    // Click button1 (Book) to attempt to book the flight with the invalid input
    myTicket.jButton1.doClick();
    // In ticket SQLException catch, button1IsSQLThrown set to true
    // This was work around since I wasn't able to get
    // jButton1ActionPerformed to throw an exception for some reason
    // If invalid input, and SQL not thrown, test fails
    // If invalid input, and SQL thrown, test passes
    Boolean isSQLThrown = myTicket.button1IsSQLThrown;

    // Integration Testing - Mock
    List searchCustomerMock = mock(List.class);
    searchCustomerMock.add(isSQLThrown);
    verify(searchCustomerMock).add(true);

    Assert.assertTrue(isSQLThrown);
    System.out.println("Button1 SQLException test should pass.");
  }

  // Testing invalid values entered into Customer ID
  @Test
  public void testCustomerIDInput() throws InterruptedException {
    // Acceptable values
    Pattern pattern = Pattern.compile("[A-Za-z]");
    ticket myTicket = new ticket();
    myTicket.setVisible(true);
    // Get the textfield
    JTextField customerIDText = (JTextField) myTicket.getCustomerIDText();
    // Give textfield invalid value
    customerIDText.setText("♥");
    // Give it 2 seconds to accept the value
    sleep(2000);
    customerIDText.postActionEvent();
    // Look for the invalid value within the list of valid values
    Matcher match = pattern.matcher(customerIDText.getText());
    // If it fails to find it, then the test passes
    boolean result = match.find();

    // Integration Testing - Mock
    List searchCustomerMock = mock(List.class);
    searchCustomerMock.add(!result);
    verify(searchCustomerMock).add(true);

    Assert.assertTrue(!result);
  }

  @Test
  public void testButton2() {
    ticket create = new ticket();
    create.setVisible(true);
    create.jButton2.doClick();
    Boolean isHidden = create.getVisibility();
    System.out.println("Button2 test should pass.");

    // Integration Testing - Mock
    List searchCustomerMock = mock(List.class);
    searchCustomerMock.add(isHidden);
    verify(searchCustomerMock).add(true);

    Assert.assertTrue(isHidden);
  }

}
