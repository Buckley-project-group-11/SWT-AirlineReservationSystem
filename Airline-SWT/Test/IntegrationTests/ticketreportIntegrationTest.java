package IntegrationTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import source.ticketreport;

public class ticketreportIntegrationTest {

  // Tests SQLException for Button 1 (Cancel)
  @Test
  public void testButton1() {
    // See ticketreportUnitTest for comments
    // Create instance of the ticketreport class
    ticketreport report = new ticketreport();
    report.setVisible(true);
    // Clicks cancel button, which should hide the ticket report screen
    report.jButton1.doClick();
    // Checks boolean to see if screen is hidden
    Boolean isHidden = report.getVisibility();
    System.out.println("Button1 test should pass.");
    // Mock
    List ticketReportMock = mock(List.class);
    ticketReportMock.add(isHidden);
    verify(ticketReportMock).add(true);
  }
}
