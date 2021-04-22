package IntegrationTests;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import org.junit.Assert;
import org.junit.Test;
import source.ticket;

public class ticketIntegrationTest {

  @Test
  public void testButton1SQLException() throws InterruptedException {
    // See ticketUnitTest for comments
    ticket myTicket = new ticket();
    myTicket.setVisible(true);
    JTextField priceText = (JTextField) myTicket.getPriceText();
    priceText.setText("ABC");
    sleep(2000);
    myTicket.jButton1.doClick();
    Boolean isSQLThrown = myTicket.button1IsSQLThrown;
    // Mock
    List ticketMock = mock(List.class);
    ticketMock.add(isSQLThrown);
    verify(ticketMock).add(true);
  }

  @Test
  public void testCustomerIDInput() throws InterruptedException {
    // See ticketUnitTest for comments
    Pattern pattern = Pattern.compile("[A-Za-z]");
    ticket myTicket = new ticket();
    myTicket.setVisible(true);
    JTextField customerIDText = (JTextField) myTicket.getCustomerIDText();
    customerIDText.setText("♥");
    sleep(2000);
    customerIDText.postActionEvent();
    Matcher match = pattern.matcher(customerIDText.getText());
    boolean result = match.find();
    // Mock
    List ticketMock = mock(List.class);
    ticketMock.add(!result);
    verify(ticketMock).add(true);
  }

  @Test
  public void testButton2() {
    // See ticketUnitTest for comments
    ticket create = new ticket();
    create.setVisible(true);
    create.jButton2.doClick();
    Boolean isHidden = create.getVisibility();
    System.out.println("Button2 test should pass.");
    // Mock
    List ticketMock = mock(List.class);
    ticketMock.add(isHidden);
    verify(ticketMock).add(true);
  }

}
