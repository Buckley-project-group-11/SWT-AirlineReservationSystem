import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    // Integration Testing - Mock
    List ticketReportMock = mock(List.class);
    ticketReportMock.add(isHidden);
    verify(ticketReportMock).add(true);

    Assert.assertTrue(isHidden);
  }

}
