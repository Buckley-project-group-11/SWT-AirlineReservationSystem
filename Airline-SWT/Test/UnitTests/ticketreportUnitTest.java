package UnitTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import source.ticketreport;

public class ticketreportUnitTest extends TestCase {

  // Tests SQLException for Button 1 (Cancel)
  @Test
  public void testButton1() {
    // Create instance of the ticketreport class
    ticketreport report = new ticketreport();
    report.setVisible(true);
    // Clicks cancel button, which should hide the ticket report screen
    report.jButton1.doClick();
    // Checks boolean to see if screen is hidden
    Boolean isHidden = report.getVisibility();
    System.out.println("Button1 test should pass.");
    // If boolean true, then test will pass
    Assert.assertTrue(isHidden);
  }
}