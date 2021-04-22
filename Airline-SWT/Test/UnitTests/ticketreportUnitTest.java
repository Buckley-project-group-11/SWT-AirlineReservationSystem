package UnitTests;

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
    report.LoadData();
    // Clicks cancel button, which should hide the ticket report screen
    report.jButton1.doClick();
    // Checks boolean to see if screen is hidden
    Boolean isHidden = report.getVisibility();
    System.out.println("Button1 test should pass.");
    // If boolean true, then test will pass
    Assert.assertTrue(isHidden);
  }

  @Test
  public void test_sql_exception(){
    ticketreport ex_test = new ticketreport();
    ex_test.LoadData();

  }

}