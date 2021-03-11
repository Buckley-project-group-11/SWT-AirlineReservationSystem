import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class ticketreportTest {

  // Tests SQLException for Button 1 (Book)
  @Test
  /* This test was constructed to test if the customer was valid, then
   * testing if the customer exists. The customer file is 2 letters followed
   * by 3 numbers.
   */
  public void testButton1() {
    // Create instance of the searchCustomer class
    ticketreport report = new ticketreport();
    report.setVisible(true);

    report.jButton1.doClick();
    Boolean isHidden =report.getVisibility();

    System.out.println("CANCEL WORKED!");

    Assert.assertTrue(isHidden);

  }

}
