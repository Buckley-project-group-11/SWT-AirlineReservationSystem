import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class ticketreportTest {

  // Tests SQLException for Button 1 (Book)
  @Test
  public void testButton1() {
    // Create instance of the ticketreport class
    ticketreport report = new ticketreport();
    report.setVisible(true);
    report.jButton1.doClick();
    Boolean isHidden =report.getVisibility();
    System.out.println("Button1 test should pass.");
    Assert.assertTrue(isHidden);

  }

}
